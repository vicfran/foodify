package es.foodify.ui.common

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TimeModel(val hour: Int = 0, val minutes: Int = 0) {

    override fun toString() =
            (if (hour == 0) "00" else if (hour < 10) "0"+ hour.toString() else hour.toString()) +
            ":" +
            (if (minutes == 0) "00" else if (minutes < 10) "0" + minutes.toString() else minutes.toString())

}

/**
 * Creates a TimeModel from hh:mm string, a time in hours and minutes
 */
fun String.toTimeModel(): TimeModel {
    return try {
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        dateFormat.parse(this)
        TimeModel(dateFormat.calendar.get(Calendar.HOUR_OF_DAY), dateFormat.calendar.get(Calendar.MINUTE))
    } catch (exception: Exception) {
        TimeModel()
    }
}
