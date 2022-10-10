package com.mr.misti.location.data.repository

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.core.utils.toSuccess
import com.mr.misti.location.domain.model.Location
import com.mr.misti.location.domain.repository.LocationRepository
import kotlinx.coroutines.delay

class LocationRepositoryImpl: LocationRepository {
    private val locationsList = listOf(
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú"),
        Location("Arequipa", "Perú")
    )
    override suspend fun getLocation(): Either<Failure, List<Location>> {
        delay(2000)
        return locationsList.toSuccess()
    }
}