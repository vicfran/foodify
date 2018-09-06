package es.foodify.domain

import es.foodify.domain.models.Foods

interface FoodRepository {

    fun foods(): Foods

}