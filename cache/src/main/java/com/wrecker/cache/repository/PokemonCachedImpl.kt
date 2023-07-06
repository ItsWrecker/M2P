package com.wrecker.cache.repository

import com.wrecker.cache.database.PokemonDatabase
import com.wrecker.cache.mapper.PokemonMapper
import com.wrecker.data.model.Pokemon
import com.wrecker.data.repository.PokemonCache
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PokemonCachedImpl @Inject constructor(
    private val pokemonDatabase: PokemonDatabase,
    private val mapper: PokemonMapper
) : PokemonCache {
    override suspend fun updatePokemon(listPokemon: List<Pokemon>) {
        listPokemon.map {
            mapper.mapToCache(it)
        }.onEach {
            pokemonDatabase.getPokemonDao().upsertPokemon(it)
        }
    }

    override suspend fun getPokemon(): List<Pokemon> {
        return pokemonDatabase.getPokemonDao().getPokemon().first().map { pokemon ->
            mapper.mapFromCache(pokemon)
        }
    }

    override suspend fun getPokemonByHp(): List<Pokemon> {
        return pokemonDatabase.getPokemonDao().getPokemonOrderByHP().first().map { pokemon ->
            mapper.mapFromCache(pokemon)
        }
    }

    override suspend fun getPokemonByLevel(): List<Pokemon> {
        return pokemonDatabase.getPokemonDao().getPokemonOrderByLevel().first().map { pokemon ->
            mapper.mapFromCache(pokemon)
        }
    }

    override suspend fun isCached(): Boolean {
        return false
    }

    override fun setLastCachedTime(lastCache: Long) {

    }

    override fun isExpired(): Boolean {
        return true
    }

}