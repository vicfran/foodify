package es.foodify.ui.profile

import es.foodify.common.RepositoryProvider
import es.foodify.ui.common.BasePresenter
import es.foodify.ui.common.models.TimeModel
import es.foodify.ui.common.models.toFoodsModel
import es.foodify.ui.common.models.toTimeModel
import es.foodify.ui.common.models.toViewModel

class ProfilePresenter(private val view: ProfileView, repositoryProvider: RepositoryProvider) : BasePresenter() {

    private val userRepository = repositoryProvider.foodieRepository
    private val foodsRepository = repositoryProvider.foodRepository

    fun onProfileNeeded() = view.showProfile(userRepository.getMyProfile().toViewModel())

    fun onImageClicked() {}

    fun onNameClicked(name: String) {
        view.showEditName(name)
    }

    fun onNameChanged(name: String) {
        view.showName(name)
    }

    fun onLocationClicked(location: String) {
        view.showEditLocation(location)
    }

    fun onLocationSelected(location: String) {
        view.showLocation(location)
    }

    fun onFoodsClicked(foods: String) {
        view.showEditFoods(foods.toFoodsModel(), foodsRepository.foods().toViewModel())
    }

    fun onFoodsChanged(foods: List<String>) {
        view.showFoods(foods.toFoodsModel())
    }

    fun onTimeClicked(time: String) {
        view.showEditTime(time.toTimeModel())
    }

    fun onTimeChanged(hour: Int, minutes: Int) {
        view.showTime(TimeModel(hour, minutes))
    }

}