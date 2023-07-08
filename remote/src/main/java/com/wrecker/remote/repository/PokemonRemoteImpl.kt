package com.wrecker.remote.repository

import com.wrecker.data.model.Pokemon
import com.wrecker.data.repository.PokemonRemote
import com.wrecker.remote.api.PokemonApi
import com.wrecker.remote.mapper.PokemonEntityMapper
import javax.inject.Inject

class PokemonRemoteImpl @Inject constructor(
    private val pokemonApi: PokemonApi,
    private val mapper: PokemonEntityMapper
) : PokemonRemote {
    override suspend fun getPokemon(page: Int): List<Pokemon> {
        val response = pokemonApi.getPokemonData(10)

        if (response.isSuccessful) {
            val data = response.body()?.data?.map { data ->
                mapper.mapFromModel(data)
            }
            println("NETWORK==> $data")
            return data ?: emptyList()
        }
        return emptyList()
    }
}