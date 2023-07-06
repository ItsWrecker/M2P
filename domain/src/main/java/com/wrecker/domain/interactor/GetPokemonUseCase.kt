package com.wrecker.domain.interactor

import com.wrecker.domain.events.Event
import com.wrecker.domain.model.Responses
import com.wrecker.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


typealias GetPokeMonUseCase = BaseUseCase<Int, Flow<Event<Responses>>>

class GetPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : GetPokeMonUseCase {

    override suspend fun invoke(params: Int): Flow<Event<Responses>> {
        return pokemonRepository.getPokemon(params)
    }


}