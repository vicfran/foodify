package es.foodify.data

import es.foodify.domain.FoodRepository
import es.foodify.domain.models.Food
import es.foodify.domain.models.Foods

class FoodDataRepository: FoodRepository {

    override fun foods(): Foods =
        Foods(listOf(
            Food("Español"),
            Food("Italiano"),
            Food("Chino"),
            Food("Mexicano")
        ))

}