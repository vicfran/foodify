package es.foodify.data

import es.foodify.domain.models.Food
import es.foodify.domain.models.Foods
import es.foodify.domain.models.Time
import es.foodify.domain.models.User
import es.foodify.domain.repositories.UserRepository

class UserDataRepository : UserRepository {

    override fun getMyProfile(): User =
        User(
            "Victor de Francisco",
            "Madrid",
            Foods(listOf(Food("Chino"), Food("Italiano"))),
            Time(14, 15)
        )

}