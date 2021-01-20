package reactive.pet.company.presentation.controller

import com.google.gson.Gson
import reactive.pet.company.application.dto.CreatePetDTO
import reactive.pet.company.application.dto.UpdatePetDTO
import reactive.pet.company.application.services.PetServiceInterface
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class PetController @Inject constructor(
        val service: PetServiceInterface
): PetControllerInterface {
    val gson = Gson()

    override fun createPet(message: String) : String {
        val dto = gson.fromJson(message, CreatePetDTO::class.java)
        val newPet = service.createPet(dto)

        return gson.toJson(newPet).toString()
    }

    override fun updatePet(message: String): String {
        val dto = gson.fromJson(message, UpdatePetDTO::class.java)
        val updatedPet = service.updatePet(dto)

        return gson.toJson(updatedPet).toString()
    }

    override fun deletePet(message: String): String {
        val uuid = message
        val petDeleted = service.removePet(uuid)
        if (petDeleted) {
            return "ok"
        }
        return ""
    }

}