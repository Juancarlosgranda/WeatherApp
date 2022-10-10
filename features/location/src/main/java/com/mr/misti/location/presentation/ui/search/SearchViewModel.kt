package com.mr.misti.location.presentation.ui.search

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import com.mr.misti.core.Failure
import com.mr.misti.location.domain.model.Location
import com.mr.misti.location.domain.usecase.GetLocations
import com.mr.misti.location.presentation.ui.state.SearchState
import com.mr.misti.weather.design.di.ViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val getLocations: GetLocations
) : ViewModel() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var getLocationJob: Job? = null
    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

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

    fun getLocations(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getLocations.invoke()
            withContext(Dispatchers.Main) {
                result.either(::handleUseCaseFailureFromBase) {
                    _state.value = _state.value.copy(locations = it)
                    Log.v("quack", "load locations successful")
                }
            }
        }
//        getNotesJob = noteUseCases.getNotes(noteOrder)
//            .onEach { notes ->
//                _state.value = state.value.copy(
//                    notes = notes,
//                    noteOrder = noteOrder
//                )
//            }
//            .launchIn(viewModelScope)
    }

    fun handleUseCaseFailureFromBase(failure: Failure) {

    }

    companion object {
        fun getViewModel(
            owner: ViewModelStoreOwner,
            viewModelFactory: ViewModelFactory
        ): SearchViewModel {
            return ViewModelProvider(owner, viewModelFactory)[SearchViewModel::class.java]

        }
    }
}