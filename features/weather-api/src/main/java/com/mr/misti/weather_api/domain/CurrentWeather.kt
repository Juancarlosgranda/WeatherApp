package com.mr.misti.weather_api.domain

data class CurrentWeather(
    val tempCelsius: String,
    val condition: String,
    val iconUrl: String,
)
