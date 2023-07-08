package com.wrecker.presentation.viewModel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wrecker.domain.events.Event
import com.wrecker.domain.interactor.GetPokemonDetails
import com.wrecker.presentation.viewModel.state.DetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val getPokemonDetails: GetPokemonDetails
) : ViewModel() {

    private val TAG = "PokemonDetails"

    private val _state = MutableStateFlow(DetailsState())
    val state: StateFlow<DetailsState> = _state


    fun details(id: String) = viewModelScope.launch {
        getPokemonDetails(id).collectLatest {
            when (it) {
                is Event.Error -> Log.e(TAG, it.message)
                Event.Loading -> _state.value = _state.value.copy(isLoading = true)
                is Event.Success -> {
                    _state.value = _state.value.copy(data = it.data, isLoading = false)
                }
            }
        }
    }

}