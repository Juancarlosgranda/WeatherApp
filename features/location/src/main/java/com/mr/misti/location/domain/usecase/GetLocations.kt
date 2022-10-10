package com.mr.misti.location.domain.usecase

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.location.domain.model.Location
import com.mr.misti.location.domain.repository.LocationRepository
import javax.inject.Inject

class GetLocations @Inject constructor (
    private val repository: LocationRepository
) {

    suspend operator fun invoke(): Either<Failure, List<Location>> {
        return repository.getLocation()
    }

}