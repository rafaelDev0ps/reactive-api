package reactive.pet.company.presentation.amqp

import com.google.gson.Gson
import io.smallrye.reactive.messaging.annotations.Broadcast
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Outgoing
import reactive.pet.company.application.dto.PetDTO
import reactive.pet.company.presentation.controller.PetControllerInterface
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class PetConsumer @Inject constructor(
        private val controller: PetControllerInterface
){
    val gson = Gson()

    @Incoming("pet")
    @Outgoing("my-data-stream")
    @Broadcast
    fun handler(message: String) : String {
        println(message)
        val operation = gson.fromJson(message, PetDTO::class.java)
        println(operation)
        return when (operation.operation) {
            "create" -> {
                controller.createPet(message)
            }
            "update" -> {
                controller.updatePet(message)
            }
            "delete" -> {
                controller.deletePet(message)
            }
            else -> throw Exception()
        }

    }
}
