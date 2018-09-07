package es.foodify.ui.foodifiers

import es.foodify.common.RepositoryProvider
import es.foodify.ui.common.BasePresenter

class FoodiesPresenter(private val view: FoodiesView, repositoryProvider: RepositoryProvider) : BasePresenter() {}