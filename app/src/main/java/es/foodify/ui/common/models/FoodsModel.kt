package es.foodify.ui.common.models

class FoodsModel(val values: List<FoodModel> = emptyList()) {

    override fun toString() = values.joinToString(separator = ", ", transform = { it.name })

    fun get() = values.map { it.name }

}

fun String.toFoodsModel() = FoodsModel(split(",").map { FoodModel(it.trim()) })

fun List<String>.toFoodsModel() = FoodsModel(map { FoodModel(it) })

fun FoodsModel.getSelected(all: FoodsModel): BooleanArray {
    val selected = mutableListOf<Boolean>()
    for (food in all.values) {
        selected.add(values.contains(food))
    }
    return selected.toBooleanArray()
}
