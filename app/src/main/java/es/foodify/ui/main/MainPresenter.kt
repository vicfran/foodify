package es.foodify.ui.main

import es.foodify.ui.common.BasePresenter

class MainPresenter(private val view: MainView) : BasePresenter() {

    fun onInit() {
        view.showProfile()
    }

}