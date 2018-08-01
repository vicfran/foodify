package es.foodify.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import es.foodify.R
import es.foodify.R.id
import es.foodify.R.layout
import es.foodify.ui.common.BaseActivity
import es.foodify.ui.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.navigation

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        init()
    }

    override fun presenter(): MainPresenter = MainPresenter(this)

    override fun showProfile() {
        loadFragment(profileFragment)
    }

    private fun init() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        presenter.onInit()
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment)
        transaction.commit()
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
