package com.wrecker.presentation.action

import com.wrecker.domain.model.Data
import com.wrecker.presentation.viewModel.state.SortType


sealed interface PokemonAction {
    data class OrderBy(val order: SortType) : PokemonAction

    data class Search(val input: String): PokemonAction
    data class GetPokemon(val page: Int) : PokemonAction
}