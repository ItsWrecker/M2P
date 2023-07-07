package com.wrecker.m2p.di

import android.content.Context
import androidx.room.Room
import com.wrecker.cache.database.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideCache(
        context: Context
    ): PokemonDatabase = Room.databaseBuilder(
        context, PokemonDatabase::class.java, "pokemon.db"
    ).build()



}