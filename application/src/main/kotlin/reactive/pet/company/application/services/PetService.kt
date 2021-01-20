package reactive.pet.company.application.services

import reactive.pet.company.application.dto.CreatePetDTO
import reactive.pet.company.application.dto.UpdatePetDTO
import reactive.pet.company.application.validators.nameAndRaceValidator
import reactive.pet.company.domain.entities.Pet
import reactive.pet.company.domain.payloads.CreatePetPayload
import reactive.pet.company.domain.payloads.UpdatePetPayload
import reactive.pet.company.domain.services.CRUDServiceInterface
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class PetService @Inject constructor(
        private val crudService: CRUDServiceInterface
) : PetServiceInterface {
    override fun createPet(dto: CreatePetDTO) : Pet {
        val formattedName = nameAndRaceValidator(dto.name)
        val formattedRace = nameAndRaceValidator(dto.race)

        val payload = CreatePetPayload(formattedName, formattedRace, dto.age)

        return crudService.create(payload)
    }

    override fun updatePet(dto: UpdatePetDTO): Pet {
        val updatePayload = UpdatePetPayload(dto.id, dto.name, dto.race, dto.age)
        return crudService.update(updatePayload)
    }

    override fun removePet(id: String): Boolean {
        return crudService.delete(id)
    }
}