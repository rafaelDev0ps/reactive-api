package reactive.pet.company.domain.repositories

import reactive.pet.company.domain.entities.Pet

interface CRUDPetRepositoryInterface : RepositoryInterface<Pet>{
    override fun create(pet: Pet): Pet
}