package com.mr.misti.location.presentation.ui.state

import com.mr.misti.location.domain.model.Location

data class SearchState(
    val locations: List<Location> = emptyList(),
    val locationsIsEmpty: Boolean = false
)
