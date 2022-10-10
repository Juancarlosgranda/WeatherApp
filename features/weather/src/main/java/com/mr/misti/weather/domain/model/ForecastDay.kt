package com.mr.misti.weather.domain.model

data class ForecastDay(
    val date: String,
    val avgTempCelsius: String,
    val iconUrl: String,
    val condition: String
)
