package com.mr.misti.weather.presentation.ui.forecast

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mr.misti.core.Failure
import com.mr.misti.weather.design.utils.handleUseCaseFailure
import com.mr.misti.weather.domain.usecase.GetForecasts
import com.mr.misti.weather.presentation.model.ForecastDayModel
import com.mr.misti.weather.presentation.ui.state.ForecastState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecasts: GetForecasts
) : ViewModel() {
    private val _state = mutableStateOf(ForecastState())
    val state: State<ForecastState> = _state

    fun getForecasts(location: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getForecasts.invoke(location, "3")
            withContext(Dispatchers.Main) {
                result.either(::handleUseCaseFailureFromBase) { forecast ->
                    _state.value = _state.value.copy(
                        location = forecast.location,
                        currentWeather = forecast.currentWeather,
                        forecastDays = forecast.forecastDays.map {
                            ForecastDayModel.fromForecastDay(it)
                        }.sortedBy { it.date }
                    )
                }
            }
        }
    }


    private fun handleUseCaseFailureFromBase(failure: Failure) {
        _state.value = _state.value.copy(showMessageError = handleUseCaseFailure(failure))
    }


}