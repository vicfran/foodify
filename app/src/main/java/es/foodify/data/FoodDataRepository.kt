package es.foodify.data

import es.foodify.domain.models.Food
import es.foodify.domain.models.Foods
import es.foodify.domain.repositories.FoodRepository

class FoodDataRepository: FoodRepository {

    override fun foods(): Foods =
        Foods(listOf(
            Food("Español"),
            Food("Italiano"),
            Food("Chino"),
            Food("Mexicano")
        ))

}