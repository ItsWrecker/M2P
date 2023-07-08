package com.wrecker.domain.repository

import com.wrecker.domain.events.Event
import com.wrecker.domain.model.Data
import com.wrecker.domain.model.Responses
import kotlinx.coroutines.flow.Flow


interface PokemonRepository {

    //Remote and cache
    suspend fun getPokemon(pageNumber: Int): Flow<Event<Responses>>
    suspend fun getPokemonByHP(): Flow<Event<Responses>>
    suspend fun getPokemonByLevel(): Flow<Event<Responses>>

    suspend fun getPokemonDetails(id: String): Flow<Event<Data>>


}