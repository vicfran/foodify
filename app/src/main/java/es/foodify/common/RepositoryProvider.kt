package es.foodify.common

import es.foodify.data.FoodDataRepository
import es.foodify.data.FoodieDataRepository

class RepositoryProvider {

    val foodieRepository = FoodieDataRepository()

    val foodRepository = FoodDataRepository()

}