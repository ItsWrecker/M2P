package com.wrecker.data.repository

import com.wrecker.data.mapper.PokemonMapper
import com.wrecker.data.model.Pokemon
import com.wrecker.data.sources.PokemonDataSourceFactory
import com.wrecker.domain.events.Event
import com.wrecker.domain.model.Data
import com.wrecker.domain.model.Responses
import com.wrecker.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val dataSourceFactory: PokemonDataSourceFactory,
    private val mapper: PokemonMapper
) : PokemonRepository {

    override suspend fun getPokemon(pageNumber: Int): Flow<Event<Responses>> = flow {
        emit(Event.Loading)
        try {
            val isCached = dataSourceFactory.getCacheDataSource().isCached()
            val pokemonList =
                dataSourceFactory.getDataSource(isCached).getPokemon(pageNumber)
                    .map { pokemon: Pokemon ->
                        mapper.mapToEntity(pokemon)
                    }.toCollection(ArrayList())
            if (pokemonList.isEmpty()) return@flow emit(Event.Error("error while fetching the pokemon"))
            updatePokemon(pokemonList)
            return@flow emit(Event.Success(Responses(data = pokemonList)))
        } catch (exception: Exception) {
            return@flow emit(Event.Error(exception.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getPokemonByHP(): Flow<Event<Responses>> = flow {
        emit(Event.Loading)
        try {
            val isCached = dataSourceFactory.getCacheDataSource().isCached()
            if (isCached) {
                val pokemonList =
                    dataSourceFactory.getCacheDataSource().getPokemonByHp()
                        .map { pokemon: Pokemon ->
                            mapper.mapToEntity(pokemon)
                        }.toCollection(ArrayList())
                return@flow emit(Event.Success(Responses(data = pokemonList)))
            } else {
                val pokemonList =
                    dataSourceFactory.getRemoteDataSource().getPokemon(0).map { pokemon: Pokemon ->
                        mapper.mapToEntity(pokemon)
                    }.toCollection(ArrayList())
                updatePokemon(pokemonList)

                dataSourceFactory.getCacheDataSource().getPokemonByHp().map { pokemon: Pokemon ->
                    mapper.mapToEntity(pokemon)
                }.toCollection(ArrayList()).let {
                    return@flow emit(Event.Success(Responses(data = it)))
                }
            }
        } catch (exception: Exception) {
            return@flow emit(Event.Error(exception.message.toString()))
        }

    }.flowOn(Dispatchers.IO)

    override suspend fun getPokemonByLevel(): Flow<Event<Responses>> = flow {
        emit(Event.Loading)
        try {
            val isCached = dataSourceFactory.getCacheDataSource().isCached()
            if (isCached) {
                val pokemonList =
                    dataSourceFactory.getCacheDataSource().getPokemonByLevel()
                        .map { pokemon: Pokemon ->
                            mapper.mapToEntity(pokemon)
                        }.toCollection(ArrayList())
                return@flow emit(Event.Success(Responses(data = pokemonList)))
            } else {
                val pokemonList =
                    dataSourceFactory.getRemoteDataSource().getPokemon(0).map { pokemon: Pokemon ->
                        mapper.mapToEntity(pokemon)
                    }.toCollection(ArrayList())

                updatePokemon(pokemonList)

                dataSourceFactory.getCacheDataSource().getPokemonByLevel().map { pokemon: Pokemon ->
                    mapper.mapToEntity(pokemon)
                }.toCollection(ArrayList()).let {
                    return@flow emit(Event.Success(Responses(data = it)))
                }
            }
        } catch (exception: Exception) {
            return@flow emit(Event.Error(exception.message.toString()))
        }
    }

    private suspend fun updatePokemon(pokemonList: ArrayList<Data>) {
        val pokemonEntity = pokemonList.toList().map { data ->
            mapper.mapFromEntity(data)
        }

        dataSourceFactory.getCacheDataSource().updatePokemon(pokemonEntity)
    }


    override suspend fun getPokemonDetails(id: String): Flow<Event<Data>> = flow {

        emit(Event.Loading)
        try {
            val data = dataSourceFactory.getCacheDataSource().getPokemonDetails(id).let {
                return@let Data(
                    id = it.id,
                    name = it.name,
                    subtypes = it.subtypes,
                    level = it.level,
                    attacks = it.attacks,
                    images = it.images,
                    hp = it.hp,
                    weaknesses = it.weaknesses,
                    types = it.types,
                    resistances = it.resistances

                )
            }
            return@flow emit(Event.Success(data))
        } catch (exception: Exception) {
            return@flow emit(Event.Error(exception.message.toString()))
        }
    }

}