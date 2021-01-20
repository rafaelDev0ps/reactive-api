package reactive.pet.company.presentation.controller

interface PetControllerInterface {
    fun createPet(message: String): String
    fun updatePet(message: String): String
    fun deletePet(message: String): String
}