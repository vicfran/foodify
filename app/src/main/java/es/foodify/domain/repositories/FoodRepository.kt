package es.foodify.domain.repositories

import es.foodify.domain.models.Foods

interface FoodRepository {

    fun foods(): Foods

}