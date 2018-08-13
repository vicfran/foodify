package es.foodify.ui.profile

import es.foodify.ui.common.BasePresenter
import es.foodify.ui.common.TimeModel
import es.foodify.ui.common.toTimeModel

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
        view.showEditTime(time.toTimeModel())
    }

    fun onTimeChanged(hour: Int, minutes: Int) {
        view.showChangedTime(TimeModel(hour, minutes).toString())
    }

}