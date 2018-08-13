package es.foodify.ui.profile

import es.foodify.ui.common.BasePresenter

class ProfilePresenter(private val view: ProfileView) : BasePresenter() {

    fun onImageClicked() {}

    fun onNameClicked(name: String) {
        view.showEditName(name)
    }

    fun onNameChanged(name: String) {
        view.showChangedName(name)
    }

    fun onLocationClicked(location: String) {
        view.showEditLocation(location)
    }

    fun onFoodClicked(food: String) {
        view.showEditFood(food)
    }

    fun onTimeClicked(time: String) {
        view.showEditTime(time)
    }

    fun onTimeChanged(hourOfDay: Int, minute: Int) {
        view.showChangedTime("$hourOfDay:$minute")
    }

}