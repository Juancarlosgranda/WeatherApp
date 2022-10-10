package com.mr.misti.weather.domain.model

import com.mr.misti.location_api.domain.Location

data class Forecast(
    val location: Location,
    val currentWeather: CurrentWeather,
    val forecastDays: List<ForecastDay>
)
