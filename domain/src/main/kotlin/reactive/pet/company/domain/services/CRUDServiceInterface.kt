package reactive.pet.company.domain.services

import reactive.pet.company.domain.entities.Pet
import reactive.pet.company.domain.payloads.CreatePetPayload
import reactive.pet.company.domain.payloads.UpdatePetPayload

interface CRUDServiceInterface {
    fun create(payload: CreatePetPayload): Pet
    fun update(payload: UpdatePetPayload): Pet
    fun delete(id: String): Boolean
}