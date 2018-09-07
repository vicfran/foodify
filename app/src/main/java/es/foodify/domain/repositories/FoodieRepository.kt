package es.foodify.domain.repositories

import es.foodify.domain.models.Foodie

interface FoodieRepository {

    fun getMyProfile(): Foodie

}