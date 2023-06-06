package com.mr.misti.weather.data.source.remote.model

import com.google.gson.annotations.SerializedName
import com.mr.misti.weather_api.data.LocationResponse
import com.mr.misti.weather_api.data.toDomainModel
import com.mr.misti.weather_api.domain.CurrentWeather
import com.mr.misti.weather_api.domain.Forecast
import com.mr.misti.weather_api.domain.ForecastDay

data class ForecastResponse(
    val location: LocationResponse,
    @SerializedName("current")
    val currentWeather: CurrentWeatherResponse,
    val forecast: ForecastDay
) {
    data class ForecastDay(
        @SerializedName("forecastday")
        val forecastDay: List<ForecastDayResponse>
    )
}

data class CurrentWeatherResponse(
    @SerializedName("temp_c")
    val tempCelsius: Double,
    @SerializedName("condition")
    val condition: ConditionWeatherResponse
)

data class ForecastDayResponse(
    val date: String,
    val day: Day
) {
    data class Day(
        @SerializedName("avgtemp_c")
        val tempCelsius: String,
        val condition: ConditionWeatherResponse
    )
}

data class ConditionWeatherResponse(
    @SerializedName("text")
    val condition: String,
    @SerializedName("icon")
    val iconUrl: String
)

fun ForecastDayResponse.toDomainModel() = ForecastDay(
    date = date,
    avgTempCelsius = day.tempCelsius,
    iconUrl = "https:${day.condition.iconUrl}",
    condition = day.condition.condition
)

fun CurrentWeatherResponse.toDomainModel() = CurrentWeather(
    tempCelsius = tempCelsius.toInt().toString(),
    condition = condition.condition,
    iconUrl = "https:${condition.iconUrl}"
)

fun ForecastResponse.toDomainModel() = Forecast(
    location = location.toDomainModel(),
    currentWeather = currentWeather.toDomainModel(),
    forecastDays = forecast.forecastDay.map {
        it.toDomainModel()
    }
)

