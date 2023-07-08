package com.wrecker.domain.interactor

import com.wrecker.domain.events.Event
import com.wrecker.domain.model.Data
import com.wrecker.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonDetails @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : BaseUseCase<String, Flow<Event<Data>>> {

    override suspend fun invoke(params: String): Flow<Event<Data>> {
        return pokemonRepository.getPokemonDetails(params)
    }
}