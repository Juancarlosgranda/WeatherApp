package com.mr.misti.weather.domain.model

data class CurrentWeather(
    val tempCelsius: String,
    val condition: String,
    val iconUrl: String,
)
