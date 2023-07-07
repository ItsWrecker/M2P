package com.wrecker.m2p.di

import com.wrecker.cache.entity.Pokemon
import com.wrecker.cache.mapper.CacheMapper
import com.wrecker.cache.mapper.PokemonMapper
import com.wrecker.cache.repository.PokemonCachedImpl
import com.wrecker.data.repository.PokemonCache
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface CacheBinds {

    @Binds
    @Singleton
    fun bindPokemonCacheRepository(
        impl: PokemonCachedImpl
    ): PokemonCache

    @Binds
    @Singleton
    fun bindCacheMapper(
        impl: PokemonMapper
    ): CacheMapper<Pokemon, com.wrecker.data.model.Pokemon>

}