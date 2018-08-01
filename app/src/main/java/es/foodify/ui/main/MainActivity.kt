package es.foodify.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import es.foodify.R.id
import es.foodify.R.layout
import es.foodify.ui.common.BaseActivity
import kotlinx.android.synthetic.main.activity_main.navigation

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
