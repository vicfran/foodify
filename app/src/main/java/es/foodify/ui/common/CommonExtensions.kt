package es.foodify.ui.common

import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

fun BaseActivity<*>.checkGooglePlayServicesAvailable(onError: () -> Unit, onAvailable: () -> Unit) {
    val googleApiAvailability = GoogleApiAvailability.getInstance()
    val status = googleApiAvailability.isGooglePlayServicesAvailable(applicationContext)
    if (status != ConnectionResult.SUCCESS) {
        if (googleApiAvailability.isUserResolvableError(status)) {
            val errorDialog = googleApiAvailability.getErrorDialog(this, status, 2404)
            errorDialog.setCancelable(false)
            errorDialog.show()
        } else {
            onError()
        }
    } else {
        onAvailable()
    }
}