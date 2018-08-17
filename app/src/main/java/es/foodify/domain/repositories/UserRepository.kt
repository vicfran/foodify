package es.foodify.domain.repositories

import es.foodify.domain.models.User

interface UserRepository {

    fun getMyProfile(): User

}