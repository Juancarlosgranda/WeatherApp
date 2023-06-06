package com.mr.misti.weather.presentation.ui.state

import com.mr.misti.weather_api.domain.Location
import com.mr.misti.weather_api.domain.CurrentWeather
import com.mr.misti.weather.presentation.model.ForecastDayModel

data class ForecastState(
    val location: Location? = null,
    val currentWeather: CurrentWeather? = null,
    val forecastDays: List<ForecastDayModel> = emptyList(),
    val showMessageError: Any? = null
)
