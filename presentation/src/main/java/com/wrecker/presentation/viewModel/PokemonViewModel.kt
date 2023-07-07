package com.wrecker.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wrecker.domain.interactor.GetPokemonUseCase
import com.wrecker.presentation.action.PokemonAction
import com.wrecker.presentation.viewModel.state.PokemonState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokeMonUseCase: GetPokemonUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonState())
    val state: StateFlow<PokemonState> = _state


    fun test() = viewModelScope.launch {
        getPokeMonUseCase(2).collectLatest {
            Log.e("DATA", it.toString())
        }
    }
}