package reactive.pet.company.application.services

import reactive.pet.company.application.dto.CreatePetDTO
import reactive.pet.company.application.dto.UpdatePetDTO
import reactive.pet.company.domain.entities.Pet

interface PetServiceInterface {
    fun createPet(dto: CreatePetDTO): Pet
    fun updatePet(dto: UpdatePetDTO): Pet
    fun removePet(id: String): Boolean
}