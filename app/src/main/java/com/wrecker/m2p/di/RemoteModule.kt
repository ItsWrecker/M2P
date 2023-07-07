package com.wrecker.m2p.di

import android.util.Log
import com.wrecker.remote.api.PokemonApi
import com.wrecker.remote.api.ServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun providePokemonService(): PokemonApi {
        return ServiceFactory.create(true, "https://api.pokemontcg.io/")
    }

}