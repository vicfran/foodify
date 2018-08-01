package es.foodify.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.foodify.R
import es.foodify.ui.common.BaseFragment

class ProfileFragment : BaseFragment<ProfilePresenter>(), ProfileView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun presenter(): ProfilePresenter = ProfilePresenter(this)

}