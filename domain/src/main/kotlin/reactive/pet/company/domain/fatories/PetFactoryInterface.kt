package reactive.pet.company.domain.fatories

import reactive.pet.company.domain.entities.Pet

interface PetFactoryInterface {
    fun build(name: String, race: String, age: Int): Pet
}