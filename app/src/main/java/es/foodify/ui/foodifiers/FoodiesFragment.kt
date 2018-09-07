package es.foodify.ui.foodifiers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.foodify.R
import es.foodify.ui.common.BaseFragment

class FoodiesFragment : BaseFragment<FoodiesPresenter>(), FoodiesView{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_foodies, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun presenter(): FoodiesPresenter = FoodiesPresenter(this, assembler.repositoryProvider)

}