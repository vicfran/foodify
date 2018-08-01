package es.foodify.ui.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import es.foodify.common.Assembler
import es.foodify.common.FoodifyApplication

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var assembler: Assembler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assembler = (application as FoodifyApplication).assembler
    }

}