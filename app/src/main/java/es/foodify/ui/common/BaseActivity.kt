package es.foodify.ui.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import es.foodify.common.Assembler
import es.foodify.common.FoodifyApplication

abstract class BaseActivity<P : BasePresenter> : AppCompatActivity() {

    protected lateinit var assembler: Assembler
    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assembler = (application as FoodifyApplication).assembler

        presenter = presenter()
    }

    protected abstract fun presenter() : P

}