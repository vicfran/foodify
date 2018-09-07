package es.foodify.ui.common.models

data class FoodieModel(
    val name: String = "",
    val location: String = "",
    val foods: FoodsModel = FoodsModel(),
    val time: TimeModel = TimeModel()
)