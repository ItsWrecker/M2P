package com.wrecker.presentation.action

import com.wrecker.domain.model.Data
import com.wrecker.presentation.viewModel.state.Order


sealed interface PokemonAction {
    data class OrderBy(val order: Order) : PokemonAction
    data class Details(val data: Data): PokemonAction
}