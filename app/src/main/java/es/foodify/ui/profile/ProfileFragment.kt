package es.foodify.ui.profile

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.location.places.ui.PlacePicker
import com.yarolegovich.lovelydialog.LovelyChoiceDialog
import com.yarolegovich.lovelydialog.LovelyTextInputDialog
import es.foodify.R
import es.foodify.ui.common.BaseActivity
import es.foodify.ui.common.BaseFragment
import es.foodify.ui.common.checkGooglePlayServicesAvailable
import es.foodify.ui.common.models.FoodsModel
import es.foodify.ui.common.models.TimeModel
import es.foodify.ui.common.models.getSelected
import kotlinx.android.synthetic.main.fragment_profile.ivProfile
import kotlinx.android.synthetic.main.fragment_profile.tvFoods
import kotlinx.android.synthetic.main.fragment_profile.tvLocation
import kotlinx.android.synthetic.main.fragment_profile.tvName
import kotlinx.android.synthetic.main.fragment_profile.tvTime

class ProfileFragment : BaseFragment<ProfilePresenter>(), ProfileView {

    private val REQUEST_CODE_PICK_PLACE = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivProfile.setOnClickListener { presenter.onImageClicked() }
        with (tvName) { setOnClickListener { presenter.onNameClicked(text.toString()) }}
        with (tvLocation) { setOnClickListener { presenter.onLocationClicked(text.toString()) }}
        with (tvFoods) { setOnClickListener { presenter.onFoodsClicked(text.toString()) }}
        with (tvTime) { setOnClickListener { presenter.onTimeClicked(text.toString()) }}
    }

    override fun onResume() {
        super.onResume()
        presenter.onProfileNeeded()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_PICK_PLACE) {
            if (resultCode == Activity.RESULT_OK) {
                val place = PlacePicker.getPlace(activity, data)
                Toast.makeText(activity, "Place ${place.name}", Toast.LENGTH_LONG).show()
            }
        }
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
        if (!isAdded) return
        LovelyTextInputDialog(activity)
            .setTopColorRes(R.color.colorPrimary)
            .setInitialInput(name)
            .setTitle(R.string.title_name)
            .setIcon(R.drawable.ic_face)
            .setIconTintColor(resources.getColor(R.color.baseline))
            .setConfirmButton(android.R.string.ok) { presenter.onNameChanged(it) }
            .setConfirmButtonColor(resources.getColor(R.color.colorPrimary))
            .show()
    }

    override fun showLocation(location: String) {
        tvLocation.text = location
    }

    override fun showEditLocation(location: String) {
        if (!isAdded) return

        (activity as BaseActivity<*>).checkGooglePlayServicesAvailable({}, {
            startActivityForResult(PlacePicker.IntentBuilder().build(activity), REQUEST_CODE_PICK_PLACE)
        })
    }

    override fun showFoods(foods: FoodsModel) {
        tvFoods.text = foods.toString()
    }

    override fun showEditFoods(foods: FoodsModel, all: FoodsModel) {
        if (!isAdded) return
        val options = all.get()
        val selectedFoods = foods.getSelected(all)
        LovelyChoiceDialog(activity)
            .setTopColorRes(R.color.colorPrimary)
            .setTitle(R.string.title_food)
            .setIcon(R.drawable.ic_food)
            .setIconTintColor(resources.getColor(R.color.baseline))
            .setItemsMultiChoice(options, selectedFoods) { _, items -> presenter.onFoodsChanged(items)}
            .setConfirmButtonColor(resources.getColor(R.color.colorPrimary))
            .setConfirmButtonText(android.R.string.ok)
            .show()
    }

    override fun showTime(time: TimeModel) {
        tvTime.text = time.toString()
    }

    override fun showEditTime(time: TimeModel) {
        if (!isAdded) return
        TimePickerDialog(
            activity,
            TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->  presenter.onTimeChanged(hourOfDay, minute) },
            time.hour,
            time.minutes,
            true).show()
    }

}