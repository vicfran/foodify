package es.foodify.ui.profile

import es.foodify.ui.common.models.FoodieModel
import es.foodify.ui.common.models.FoodsModel
import es.foodify.ui.common.models.TimeModel

interface ProfileView {

    fun showProfile(foodie: FoodieModel)

    fun showName(name: String)

    fun showEditName(name: String)

    fun showLocation(location: String)

    fun showEditLocation(location: String)

    fun showFoods(foods: FoodsModel)

    fun showEditFoods(foods: FoodsModel, all: FoodsModel)

    fun showTime(time: TimeModel)

    fun showEditTime(time: TimeModel)

}