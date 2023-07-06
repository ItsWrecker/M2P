package com.wrecker.data.repository

import com.wrecker.data.model.Pokemon

interface PokemonRemote {
    suspend fun getPokemon(): List<Pokemon>

}