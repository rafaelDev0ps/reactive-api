package reactive.pet.company.infra.factories

import reactive.pet.company.domain.entities.Pet
import reactive.pet.company.domain.fatories.PetFactoryInterface
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PetFactory : PetFactoryInterface {
    override fun build(name: String, race: String, age: Int): Pet {
        val uuid = UUID.randomUUID().toString()
        return Pet(uuid, name, race, age)
    }
}