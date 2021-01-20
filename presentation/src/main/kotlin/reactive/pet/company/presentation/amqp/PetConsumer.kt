package reactive.pet.company.presentation.amqp

import io.smallrye.reactive.messaging.annotations.Broadcast
import org.eclipse.microprofile.reactive.messaging.Incoming
import org.eclipse.microprofile.reactive.messaging.Outgoing
import reactive.pet.company.presentation.controller.PetControllerInterface
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class PetConsumer @Inject constructor(
        private val controller: PetControllerInterface
){
    // TODO: Colocar um campo function para determinar método create, update, ou delete. \
    //  E fazer o parse de uma unica mensagem com os campos function, name, race, id e age

    @Incoming("create-pet")
    @Outgoing("my-data-stream")
    @Broadcast
    fun createHandler(message: String) : String {
        return controller.createPet(message)
    }

    @Incoming("update-pet")
    @Outgoing("my-data-stream")
    @Broadcast
    fun updateHandler(message: String) : String {
        println(message)
        return controller.updatePet(message)
    }

    @Incoming("delete-pet")
    @Outgoing("my-data-stream")
    @Broadcast
    fun deleteHandler(message: String) : String {
        return controller.deletePet(message)
    }
}
