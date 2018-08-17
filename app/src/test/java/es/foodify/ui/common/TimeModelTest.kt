package es.foodify.ui.common

import es.foodify.ui.common.models.TimeModel
import es.foodify.ui.common.models.toTimeModel
import org.junit.Assert.assertEquals
import org.junit.Test

class TimeModelTest {

    @Test fun `given TimeModel midnight when formatting to string is correct`() {
        assertEquals("00:00", TimeModel(0, 0).toString())
    }

    @Test fun `given TimeModel midday when formatting to string is correct`() {
        assertEquals("12:00", TimeModel(12, 0).toString())
    }

    @Test fun `given TimeModel midnight past twelve when formatting to string is correct`() {
        assertEquals("00:12", TimeModel(0, 12).toString())
    }

    @Test fun `given TimeModel fifteen past one when formatting to string is correct`() {
        assertEquals("15:01", TimeModel(15, 1).toString())
    }

    @Test fun `given TimeModel fourteen past fifteen when formatting to string is correct`() {
        assertEquals("14:15", TimeModel(14, 15).toString())
    }

    @Test fun `given TimeModel twenty two past twelve when formatting to string is correct`() {
        assertEquals("22:12", TimeModel(22, 12).toString())
    }

    @Test fun `given TimeModel one past twelve when formatting to string is correct`() {
        assertEquals("01:12", TimeModel(1, 12).toString())
    }

    @Test fun `given TimeModel two past five when formatting to string is correct`() {
        assertEquals("02:05", TimeModel(2, 5).toString())
    }

    @Test fun `given string with midnight hour minutes format when calling toTimeModel then builds a TimeModel`() {
        val timeModel = "00:00".toTimeModel()
        assertEquals(0, timeModel.hour)
        assertEquals(0, timeModel.minutes)
    }

    @Test fun `given string with midday hour minutes format when calling toTimeModel then builds a TimeModel`() {
        val timeModel = "12:00".toTimeModel()
        assertEquals(12, timeModel.hour)
        assertEquals(0, timeModel.minutes)
    }

    @Test fun `given string with midnight past twelve hour minutes format when calling toTimeModel then builds a TimeModel`() {
        val timeModel = "00:12".toTimeModel()
        assertEquals(0, timeModel.hour)
        assertEquals(12, timeModel.minutes)
    }

    @Test fun `given string with fifteen past one hour minutes format when calling toTimeModel then builds a TimeModel`() {
        val timeModel = "15:01".toTimeModel()
        assertEquals(15, timeModel.hour)
        assertEquals(1, timeModel.minutes)
    }

    @Test fun `given string with fourteen past fifteen hour minutes format when calling toTimeModel then builds a TimeModel`() {
        val timeModel = "14:15".toTimeModel()
        assertEquals(14, timeModel.hour)
        assertEquals(15, timeModel.minutes)
    }

    @Test fun `given string with twenty two past twelve hour minutes format when calling toTimeModel then builds a TimeModel`() {
        val timeModel = "22:12".toTimeModel()
        assertEquals(22, timeModel.hour)
        assertEquals(12, timeModel.minutes)
    }

    @Test fun `given string with one past twelve hour minutes format when calling toTimeModel then builds a TimeModel`() {
        val timeModel = "01:12".toTimeModel()
        assertEquals(1, timeModel.hour)
        assertEquals(12, timeModel.minutes)
    }

    @Test fun `given string with two past five hour minutes format when calling toTimeModel then builds a TimeModel`() {
        val timeModel = "02:05".toTimeModel()
        assertEquals(2, timeModel.hour)
        assertEquals(5, timeModel.minutes)
    }

    @Test fun `given string with invalid hour minutes format when calling toTimeModel then builds an empty TimeModel`() {
        val timeModel = "AA:B".toTimeModel()
        assertEquals(0, timeModel.hour)
        assertEquals(0, timeModel.minutes)
    }

}
