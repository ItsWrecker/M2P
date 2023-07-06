package com.wrecker.data.sources

import com.wrecker.data.repository.PokemonCache
import com.wrecker.data.repository.PokemonDataSource
import javax.inject.Inject

open class PokemonDataSourceFactory @Inject constructor(
    private val pokemonCached: PokemonCache,
    private val cacheDataSource: PokemonCachedDataSource,
    private val remoteDataSource: PokemonRemoteDataSource
) {

    open fun getDataSource(isCached: Boolean): PokemonDataSource {
        return if (isCached && !pokemonCached.isExpired()) getCacheDataSource()
        else getRemoteDataSource()
    }


    fun getRemoteDataSource(): PokemonDataSource {
        return remoteDataSource
    }

    fun getCacheDataSource(): PokemonDataSource {
        return cacheDataSource
    }
}