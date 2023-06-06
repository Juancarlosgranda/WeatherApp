package com.mr.misti.weather.presentation.model

import com.mr.misti.weather.design.utils.convertDateFormat
import com.mr.misti.weather.design.utils.toDate
import com.mr.misti.weather_api.domain.ForecastDay
import java.util.Date

data class ForecastDayModel(
    val date: Date,
    val dateFormat: String,
    val avgTempCelsius: String,
    val iconUrl: String,
    val condition: String
) {
    companion object {
        fun fromForecastDay(forecastDay: ForecastDay): ForecastDayModel {
            val dateFormatted = forecastDay.date.convertDateFormat(
                inputDateFormat = "yyyy-MM-dd",
                outputDateFormat = "dd/MM"
            )
            return ForecastDayModel(
                date = forecastDay.date.toDate("yyyy-MM-dd"),
                dateFormat = dateFormatted,
                avgTempCelsius = forecastDay.avgTempCelsius,
                iconUrl = forecastDay.iconUrl,
                condition = forecastDay.condition
            )
        }
    }
}
