package com.wrecker.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wrecker.domain.events.Event
import com.wrecker.domain.interactor.GetPokemonByHP
import com.wrecker.domain.interactor.GetPokemonByLevel
import com.wrecker.domain.interactor.GetPokemonUseCase
import com.wrecker.domain.model.Data
import com.wrecker.presentation.action.PokemonAction
import com.wrecker.presentation.viewModel.state.PokemonState
import com.wrecker.presentation.viewModel.state.SortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokeMonUseCase: GetPokemonUseCase,
    private val getPokemonByHP: GetPokemonByHP,
    private val getPokemonByLevel: GetPokemonByLevel
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonState())
    val state: StateFlow<PokemonState> = _state

    init {
        onEvent(PokemonAction.GetPokemon(2))
    }

    fun onEvent(action: PokemonAction) = viewModelScope.launch {
        when (action) {

            is PokemonAction.Search -> {
                _state.value = _state.value.copy(
                    pokemon = _state.value.pokemon.filter {
                        it.name.startsWith(action.input, ignoreCase = true) || it.name.contains(
                            action.input,
                            ignoreCase = true
                        )
                    }
                )
            }

            is PokemonAction.OrderBy -> {
                val dataFlow = when (action.order) {
                    SortType.NAME -> getPokeMonUseCase(10)
                    SortType.BY_HP -> getPokemonByHP(Unit)
                    SortType.BY_LEVEL -> getPokemonByLevel(Unit)
                }

                dataFlow.collectLatest {
                    when (it) {
                        is Event.Error -> Log.e("VIEWMODEL", it.message)
                        Event.Loading -> Log.e("VIEWMODEL", "Loading")
                        is Event.Success -> {
                            val data: List<Data> = it.data.data
                            if (data.isNotEmpty()) {
                                _state.value = _state.value.copy(
                                    isLoading = false,
                                    pokemon = data,
                                    pokemonOrder = action.order
                                )
                            }
                        }
                    }
                }
            }

            is PokemonAction.GetPokemon -> {
                getPokeMonUseCase(action.page).collectLatest {
                    when (it) {
                        is Event.Error -> Log.e("VIEWMODEL", it.message)
                        Event.Loading -> Log.e("VIEWMODEL", "Loading")
                        is Event.Success -> {
                            val data: List<Data> = it.data.data
                            if (data.isNotEmpty()) {
                                _state.value = _state.value.copy(
                                    isLoading = false,
                                    pokemon = data
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    fun test() = viewModelScope.launch {
        getPokeMonUseCase(2).collectLatest {
            Log.e("DATA", it.toString())
        }
    }
}