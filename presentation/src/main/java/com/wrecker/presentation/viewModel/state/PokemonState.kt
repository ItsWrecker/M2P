package com.wrecker.presentation.viewModel.state

import com.wrecker.domain.model.Responses


data class PokemonState(
    val isLoading: Boolean = false,
    val pokemonOrder: Order = Order.NORMAL,
    val pokemon: Responses? = null
)

enum class Order {
    NORMAL,
    BY_HP,
    BY_LEVEL
}
