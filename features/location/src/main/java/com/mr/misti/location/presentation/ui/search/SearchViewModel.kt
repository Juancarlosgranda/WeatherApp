package com.mr.misti.location.presentation.ui.search

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mr.misti.core.Failure
import com.mr.misti.location.domain.usecase.GetLocations
import com.mr.misti.location.presentation.ui.state.SearchState
import com.mr.misti.weather.design.utils.handleUseCaseFailure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getLocations: GetLocations
) : ViewModel() {
    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun getLocations(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getLocations.invoke(query)
            withContext(Dispatchers.Main) {
                result.either(::handleUseCaseFailureFromBase) {
                    _state.value = _state.value.copy(locations = it)
                }
            }
        }
    }


    private fun handleUseCaseFailureFromBase(failure: Failure) {
        _state.value = _state.value.copy(showMessageError = handleUseCaseFailure(failure))
    }

}