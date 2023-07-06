package com.wrecker.data.sources

import com.wrecker.data.model.Pokemon
import com.wrecker.data.repository.PokemonCache
import com.wrecker.data.repository.PokemonDataSource
import javax.inject.Inject

class PokemonCachedDataSource @Inject constructor(
    private val pokemonCached: PokemonCache
) : PokemonDataSource {
    override suspend fun getPokemon(): List<Pokemon> {
        return pokemonCached.getPokemon()
    }

    override suspend fun updatePokemon(listPokemon: List<Pokemon>) {
        return pokemonCached.updatePokemon(listPokemon)
    }

    override suspend fun getPokemonByHp(): List<Pokemon> {
       return pokemonCached.getPokemonByHp()
    }

    override suspend fun getPokemonByLevel(): List<Pokemon> {
        return pokemonCached.getPokemonByLevel()
    }

    override suspend fun isCached(): Boolean {
        return pokemonCached.isCached()
    }

}