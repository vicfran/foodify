package es.foodify.ui.profile

interface ProfileView {

    fun showEditName(name: String)

    fun showChangedName(name: String)

    fun showEditLocation(location: String)

    fun showEditFood(food: String)

    fun showEditTime(time: String)

    fun showChangedTime(time: String)

}