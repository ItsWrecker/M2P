package com.wrecker.data.repository

import com.wrecker.data.model.Pokemon

interface PokemonDataSource {

    suspend fun getPokemon(): List<Pokemon>

    suspend fun updatePokemon(listPokemon: List<Pokemon>)
    suspend fun getPokemonByHp(): List<Pokemon>
    suspend fun getPokemonByLevel(): List<Pokemon>
    suspend fun isCached(): Boolean

}