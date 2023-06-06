package com.mr.misti.weather.domain.usecase

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.weather_api.domain.Forecast
import com.mr.misti.weather.domain.repository.ForecastRepository
import javax.inject.Inject

class GetForecasts @Inject constructor (
    private val repository: ForecastRepository
) {

    suspend operator fun invoke(location: String, days: String): Either<Failure, Forecast> {
        return repository.getForecasts(location, days)
    }

}