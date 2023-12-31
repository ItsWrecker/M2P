package com.wrecker.cache.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.wrecker.cache.entity.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Upsert
    fun upsertPokemon(vararg pokemon: Pokemon)

    @Query("SELECT * FROM pokemon ORDER BY name ASC")
    fun getPokemon(): Flow<List<Pokemon>>

    @Query("SELECT * FROM pokemon ORDER BY level ASC")
    fun getPokemonOrderByLevel(): Flow<List<Pokemon>>

    @Query("SELECT * FROM pokemon ORDER BY hp ASC")
    fun getPokemonOrderByHP(): Flow<List<Pokemon>>

    @Query("SELECT * FROM pokemon WHERE id =:id")
    suspend fun getPokemonDetails(id: String): Pokemon


}