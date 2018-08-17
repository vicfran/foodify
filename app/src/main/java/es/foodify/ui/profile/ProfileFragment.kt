package es.foodify.ui.profile

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yarolegovich.lovelydialog.LovelyChoiceDialog
import com.yarolegovich.lovelydialog.LovelyTextInputDialog
import es.foodify.R
import es.foodify.ui.common.BaseFragment
import es.foodify.ui.common.models.FoodsModel
import es.foodify.ui.common.models.TimeModel
import kotlinx.android.synthetic.main.fragment_profile.ivProfile
import kotlinx.android.synthetic.main.fragment_profile.tvFoods
import kotlinx.android.synthetic.main.fragment_profile.tvLocation
import kotlinx.android.synthetic.main.fragment_profile.tvName
import kotlinx.android.synthetic.main.fragment_profile.tvTime

class ProfileFragment : BaseFragment<ProfilePresenter>(), ProfileView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivProfile.setOnClickListener { presenter.onImageClicked() }
        with (tvName) { setOnClickListener { presenter.onNameClicked(text.toString()) }}
        with (tvLocation) { setOnClickListener { presenter.onLocationClicked(text.toString()) }}
        with (tvFoods) { setOnClickListener { presenter.onFoodsClicked(listOf(text.toString())) }}
        with (tvTime) { setOnClickListener { presenter.onTimeClicked(text.toString()) }}
    }

    override fun onResume() {
        super.onResume()
        presenter.onProfileNeeded()
    }

    override fun presenter(): ProfilePresenter = ProfilePresenter(this, assembler.repositoryProvider)

    override fun showProfile(profile: ProfileModel) {
        with (profile) {
            showName(name)
            showLocation(location)
            showFoods(foods)
            showTime(time)
        }
    }

    override fun showName(name: String) {
        tvName.text = name
    }

    override fun showEditName(name: String) {
        LovelyTextInputDialog(activity)
            .setTopColorRes(R.color.colorPrimary)
            .setInitialInput(name)
            .setTitle(R.string.title_name)
            .setIcon(R.drawable.ic_face)
            .setIconTintColor(resources.getColor(R.color.baseline))
            .setConfirmButton(android.R.string.ok, { presenter.onNameChanged(it) })
            .setConfirmButtonColor(resources.getColor(R.color.colorPrimary))
            .show()
    }

    override fun showLocation(location: String) {
        tvLocation.text = location
    }

    override fun showEditLocation(location: String) {}

    override fun showFoods(foods: FoodsModel) {
        tvFoods.text = foods.toString()
    }

    override fun showEditFoods(foods: FoodsModel) {
        val foods = foods.values
        LovelyChoiceDialog(activity)
            .setTopColorRes(R.color.colorPrimary)
            .setTitle(R.string.title_food)
            .setIcon(R.drawable.ic_food)
            .setIconTintColor(resources.getColor(R.color.baseline))
            .setItemsMultiChoice(foods, { positions, items -> Toast.makeText(activity, items.toString(), Toast.LENGTH_SHORT).show()})
            .setConfirmButtonColor(resources.getColor(R.color.colorPrimary))
            .setConfirmButtonText(android.R.string.ok)
            .show()
    }

    override fun showTime(time: TimeModel) {
        tvTime.text = time.toString()
    }

    override fun showEditTime(time: TimeModel) {
        TimePickerDialog(
            activity,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->  presenter.onTimeChanged(hourOfDay, minute) },
            time.hour,
            time.minutes,
            true).show()
    }

}