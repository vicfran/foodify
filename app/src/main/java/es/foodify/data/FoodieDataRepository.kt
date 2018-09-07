package es.foodify.data

import es.foodify.domain.models.Food
import es.foodify.domain.models.Foodie
import es.foodify.domain.models.Foods
import es.foodify.domain.models.Time
import es.foodify.domain.repositories.FoodieRepository

class FoodieDataRepository : FoodieRepository {

    override fun getMyProfile(): Foodie =
        Foodie(
            "Victor de Francisco",
            "Madrid",
            Foods(listOf(Food("Mexicano"), Food("Italiano"))),
            Time(14, 15)
        )

}