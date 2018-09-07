package es.foodify.ui.profile.location

import android.os.Bundle
import es.foodify.R.layout
import es.foodify.ui.common.BaseActivity
import kotlinx.android.synthetic.main.activity_location.toolbar

class LocationActivity : BaseActivity<LocationPresenter>(), LocationView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_location)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun presenter(): LocationPresenter = LocationPresenter(this, assembler.repositoryProvider)

}
