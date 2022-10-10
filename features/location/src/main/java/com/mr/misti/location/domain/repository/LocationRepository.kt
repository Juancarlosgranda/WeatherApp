package com.mr.misti.location.domain.repository

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.location.domain.model.Location

interface LocationRepository {

    suspend fun getLocation(): Either<Failure, List<Location>>

}