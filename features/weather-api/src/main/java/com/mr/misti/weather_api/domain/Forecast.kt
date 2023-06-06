package com.mr.misti.weather_api.domain

data class Forecast(
    val location: Location,
    val currentWeather: CurrentWeather,
    val forecastDays: List<ForecastDay>
)
