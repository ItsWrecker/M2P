package com.wrecker.presentation.viewModel.state

import com.wrecker.domain.model.Data


data class PokemonState(
    val isLoading: Boolean = false,
    val pokemonOrder: SortType = SortType.NAME,
    val pokemon: List<Data> = emptyList()
)

enum class SortType {
    NAME,
    BY_HP,
    BY_LEVEL
}
