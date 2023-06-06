package com.mr.misti.location.presentation.ui.state

import com.mr.misti.weather_api.domain.Location

data class SearchState(
    val locations: List<Location> = emptyList(),
    val locationsIsEmpty: Boolean = false,
    val showMessageError: Any? = null
)
