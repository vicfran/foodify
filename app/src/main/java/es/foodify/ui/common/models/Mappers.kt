package es.foodify.ui.common.models

import es.foodify.domain.models.Food
import es.foodify.domain.models.Foods
import es.foodify.domain.models.Time
import es.foodify.domain.models.User
import es.foodify.ui.profile.ProfileModel

fun User.toViewModel() =
    ProfileModel(
        name,
        location,
        foods.toViewModel(),
        time.toViewModel()
    )

fun Food.toViewModel() =
    FoodModel(
        name
    )

fun Foods.toViewModel() =
    FoodsModel(
        values.map { it.toViewModel() }
    )

fun Time.toViewModel() =
    TimeModel(
        hour,
        minutes
    )