package es.foodify.domain.models

data class Foodie(
    val name: String,
    val location: String,
    val foods: Foods,
    val time: Time
)