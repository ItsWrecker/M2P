package com.wrecker.m2p.di

import com.wrecker.data.repository.PokemonRemote
import com.wrecker.remote.repository.PokemonRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteBind {

    @Binds
    @Singleton
    fun bindsPokemonRemote(
        impl: PokemonRemoteImpl
    ): PokemonRemote
}