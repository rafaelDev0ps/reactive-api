package reactive.pet.company.infra.repositories

import com.mongodb.client.MongoCollection
import reactive.pet.company.domain.entities.Pet
import reactive.pet.company.domain.repositories.CRUDPetRepositoryInterface
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class CRUDPetRepository @Inject constructor(
        private val collection: MongoCollection<Pet>
) : CRUDPetRepositoryInterface, Repository<Pet>(collection) {}
