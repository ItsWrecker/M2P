package com.wrecker.data.repository

import com.wrecker.data.model.Pokemon

interface PokemonRemote {
    suspend fun getPokemon(page: Int): List<Pokemon>

}