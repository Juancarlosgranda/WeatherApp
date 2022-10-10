package com.mr.misti.location_api.data

import com.google.gson.annotations.SerializedName
import com.mr.misti.location_api.domain.Location

data class LocationResponse(
    val name: String?,
    val country: String?,
    @SerializedName("localtime")
    val localTime: String?
)

fun LocationResponse.toDomainModel() = Location(
    name.orEmpty(),
    country.orEmpty(),
    localTime.orEmpty()
)

