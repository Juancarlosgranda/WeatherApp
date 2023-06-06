package com.mr.misti.weather_api.domain

data class ForecastDay(
    val date: String,
    val avgTempCelsius: String,
    val iconUrl: String,
    val condition: String
)
