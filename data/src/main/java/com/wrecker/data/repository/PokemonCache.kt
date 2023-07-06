package com.wrecker.data.repository

import com.wrecker.data.model.Pokemon

interface PokemonCache {
    suspend fun updatePokemon(listPokemon: List<Pokemon>)
    suspend fun getPokemon(): List<Pokemon>
    suspend fun getPokemonByHp(): List<Pokemon>
    suspend fun getPokemonByLevel(): List<Pokemon>
    suspend fun isCached(): Boolean
    fun setLastCachedTime(lastCache: Long)
    fun isExpired(): Boolean
}