package com.wrecker.data.sources

import com.wrecker.data.model.Pokemon
import com.wrecker.data.repository.PokemonDataSource
import com.wrecker.data.repository.PokemonRemote
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(
private val pokemonRemote: PokemonRemote
) : PokemonDataSource{
    override suspend fun getPokemon(): List<Pokemon> {
        return pokemonRemote.getPokemon()
    }

    override suspend fun updatePokemon(listPokemon: List<Pokemon>) {
        throw UnsupportedOperationException("Update is not supported for remote")
    }

    override suspend fun getPokemonByHp(): List<Pokemon> {
        throw UnsupportedOperationException("Sorting not supported at remote")
    }

    override suspend fun getPokemonByLevel(): List<Pokemon> {
        throw UnsupportedOperationException("Sorting not supported at remote")
    }

    override suspend fun isCached(): Boolean {
        throw UnsupportedOperationException("Cached is not supported at remote")
    }


}