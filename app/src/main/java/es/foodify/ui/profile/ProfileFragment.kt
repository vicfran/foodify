package es.foodify.ui.profile

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yarolegovich.lovelydialog.LovelyTextInputDialog
import es.foodify.R
import es.foodify.ui.common.BaseFragment
import es.foodify.ui.common.TimeModel
import kotlinx.android.synthetic.main.fragment_profile.ivProfile
import kotlinx.android.synthetic.main.fragment_profile.tvFood
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
        with (tvFood) { setOnClickListener { presenter.onFoodClicked(text.toString()) }}
        with (tvTime) { setOnClickListener { presenter.onTimeClicked(text.toString()) }}
    }

    override fun presenter(): ProfilePresenter = ProfilePresenter(this)

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

    override fun showChangedName(name: String) {
        tvName.text = name
    }

    override fun showEditLocation(location: String) {}

    override fun showEditFood(food: String) {}

    override fun showEditTime(time: TimeModel) {
        TimePickerDialog(
            activity,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->  presenter.onTimeChanged(hourOfDay, minute) },
            time.hour,
            time.minutes,
            true).show()
    }

    override fun showChangedTime(time: String) {
        tvTime.text = time
    }

}