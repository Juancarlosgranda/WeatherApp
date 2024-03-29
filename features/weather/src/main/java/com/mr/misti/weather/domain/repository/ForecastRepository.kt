package com.mr.misti.weather.domain.repository

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.weather_api.domain.Forecast

interface ForecastRepository {

    suspend fun getForecasts(location: String, days: String): Either<Failure, Forecast>

}