package com.wrecker.data.repository

import com.wrecker.data.model.Pokemon

interface PokemonDataSource {

    suspend fun getPokemon(page: Int): List<Pokemon>

    suspend fun updatePokemon(listPokemon: List<Pokemon>)
    suspend fun getPokemonByHp(): List<Pokemon>
    suspend fun getPokemonByLevel(): List<Pokemon>
    suspend fun getPokemonDetails(id: String): Pokemon
    suspend fun isCached(): Boolean

}