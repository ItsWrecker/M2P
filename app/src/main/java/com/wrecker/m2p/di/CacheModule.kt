package com.wrecker.m2p.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.room.Room
import com.wrecker.cache.database.PokemonDatabase
import com.wrecker.cache.entity.Cache
import com.wrecker.cache.serializer.CacheSerializer
import com.wrecker.cache.serializer.CacheSerializer.dataStore
import com.wrecker.cache.serializer.DataStoreFactory
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

    @Provides
    @Singleton
    fun provideDataStore(
        context: Context
    ): DataStore<Cache> = DataStoreFactory.create(context)

}