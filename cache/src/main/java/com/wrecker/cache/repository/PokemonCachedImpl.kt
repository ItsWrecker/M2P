package com.wrecker.cache.repository

import androidx.datastore.core.DataStore
import com.wrecker.cache.database.PokemonDatabase
import com.wrecker.cache.entity.Cache
import com.wrecker.cache.mapper.PokemonMapper
import com.wrecker.data.model.Pokemon
import com.wrecker.data.repository.PokemonCache
import kotlinx.coroutines.flow.first
import java.time.Instant
import javax.inject.Inject

class PokemonCachedImpl @Inject constructor(
    private val pokemonDatabase: PokemonDatabase,
    private val mapper: PokemonMapper,
    private val dataStore: DataStore<Cache>
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
        return dataStore.data.first().cacheTimestamp != 0L
    }

    override suspend fun setLastCachedTime(lastCache: Long) {
        dataStore.updateData {
            it.copy(cacheTimestamp = lastCache)
        }
    }

    //if last update was 30 min ago, means cache is expired
    override suspend fun isExpired(): Boolean {
        val cachedTime=  dataStore.data.first().cacheTimestamp
        val currentTimestamp = Instant.now().toEpochMilli()
        val differenceInMilliseconds = currentTimestamp - cachedTime
        val differenceInMinutes = differenceInMilliseconds / (1000 * 60)
        return differenceInMinutes > 30
    }

    override suspend fun getPokemonDetails(id: String): Pokemon {
        return pokemonDatabase.getPokemonDao().getPokemonDetails(id).let {
            return@let mapper.mapFromCache(it)
        }
    }

}