package es.foodify.ui.profile

import es.foodify.ui.common.models.FoodsModel
import es.foodify.ui.common.models.TimeModel

data class ProfileModel(
    val name: String = "",
    val location: String = "",
    val foods: FoodsModel = FoodsModel(),
    val time: TimeModel = TimeModel()
)