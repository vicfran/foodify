package es.foodify.common

import es.foodify.data.FoodDataRepository
import es.foodify.data.UserDataRepository

class RepositoryProvider {

    val userRepository = UserDataRepository()

    val foodsRepository = FoodDataRepository()

}