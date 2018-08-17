package es.foodify.ui.common.models

class FoodsModel(val values: List<FoodModel> = emptyList()) {

    override fun toString() =
        values.joinToString(separator = ", ", transform = { it.name })

}

fun List<String>.toFoodsModel() = FoodsModel(map { FoodModel(it) })
