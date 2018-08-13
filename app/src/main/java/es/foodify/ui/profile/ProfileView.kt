package es.foodify.ui.profile

import es.foodify.ui.common.TimeModel

interface ProfileView {

    fun showEditName(name: String)

    fun showChangedName(name: String)

    fun showEditLocation(location: String)

    fun showEditFood(food: String)

    fun showEditTime(time: TimeModel)

    fun showChangedTime(time: String)

}