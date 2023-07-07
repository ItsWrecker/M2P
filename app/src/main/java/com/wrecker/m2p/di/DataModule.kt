package com.wrecker.m2p.di

import com.wrecker.data.repository.PokemonCache
import com.wrecker.data.repository.PokemonRepositoryImpl
import com.wrecker.data.sources.PokemonCachedDataSource
import com.wrecker.data.sources.PokemonDataSourceFactory
import com.wrecker.data.sources.PokemonRemoteDataSource
import com.wrecker.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun providePokemonDataSourceFactory(
        pokemonCached: PokemonCache,
        cacheDataSource: PokemonCachedDataSource,
        remoteDataSource: PokemonRemoteDataSource
    ): PokemonDataSourceFactory {
        return PokemonDataSourceFactory(
            pokemonCached, cacheDataSource, remoteDataSource
        )
    }

//
//    @Provides
//    @Singleton
//    fun providePokemonRepository(
//        impl: PokemonRepositoryImpl
//    ): PokemonRepository = impl
}