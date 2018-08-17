package es.foodify.common

import es.foodify.data.UserDataRepository
import es.foodify.domain.repositories.UserRepository

class RepositoryProvider {

    val userRepository: UserRepository = UserDataRepository()

}