package es.foodify.ui.common

import android.os.Bundle
import android.support.v4.app.Fragment
import es.foodify.common.Assembler
import es.foodify.common.FoodifyApplication

abstract class BaseFragment<P : BasePresenter> : Fragment() {

    protected lateinit var assembler: Assembler
    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assembler = (activity as BaseActivity<*>).application.run { (this as FoodifyApplication).assembler }
        presenter = presenter()
    }

    protected abstract fun presenter() : P

}