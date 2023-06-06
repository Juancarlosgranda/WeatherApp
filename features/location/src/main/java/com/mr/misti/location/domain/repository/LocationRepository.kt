package com.mr.misti.location.domain.repository

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.weather_api.domain.Location

interface LocationRepository {

    suspend fun getLocation(query: String): Either<Failure, List<Location>>

}