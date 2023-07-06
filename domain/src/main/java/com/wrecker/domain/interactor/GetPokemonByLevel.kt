package com.wrecker.domain.interactor

import com.wrecker.domain.events.Event
import com.wrecker.domain.model.Responses
import com.wrecker.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonByLevel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : BaseUseCase<Unit, Flow<Event<Responses>>> {
    override suspend fun invoke(params: Unit): Flow<Event<Responses>> {
        return pokemonRepository.getPokemonByLevel()
    }
}