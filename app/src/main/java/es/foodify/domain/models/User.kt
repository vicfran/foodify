package es.foodify.domain.models

data class User(
    val name: String,
    val location: String,
    val foods: Foods,
    val time: Time
)