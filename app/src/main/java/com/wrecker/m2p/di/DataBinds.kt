package com.wrecker.m2p.di

import com.wrecker.data.mapper.Mapper
import com.wrecker.data.mapper.PokemonMapper
import com.wrecker.data.model.Pokemon
import com.wrecker.data.repository.PokemonDataSource
import com.wrecker.data.repository.PokemonRepositoryImpl
import com.wrecker.data.sources.PokemonCachedDataSource
import com.wrecker.data.sources.PokemonRemoteDataSource
import com.wrecker.domain.model.Data
import com.wrecker.domain.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataBinds {


    @Binds
    @Singleton
    fun bindPokemonCacheDataSource(
        impl: PokemonCachedDataSource
    ): PokemonDataSource


    @Binds
    @Singleton
    fun bindPokemonRemoteDataSource(
        impl: PokemonRemoteDataSource
    ): PokemonDataSource

    @Binds
    @Singleton
    fun bindPokemonRepository(
        impl: PokemonRepositoryImpl
    ): PokemonRepository

    @Binds
    @Singleton
    fun bindPokemonMapper(
        impl: PokemonMapper
    ): Mapper<Data, Pokemon>



}