package com.mr.misti.weather.data.repository

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.weather.data.source.remote.ds.ForecastDataSource
import com.mr.misti.weather.data.source.remote.model.toDomainModel
import com.mr.misti.weather.domain.model.Forecast
import com.mr.misti.weather.domain.repository.ForecastRepository
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(
    private val forecastDataSource: ForecastDataSource
) : ForecastRepository {
    override suspend fun getForecasts(location: String, days: String): Either<Failure, Forecast> {
        return forecastDataSource.getForecasts(location, days).coMapSuccess {
            it.toDomainModel()
        }
    }
}