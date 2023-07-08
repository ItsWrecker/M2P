package com.wrecker.remote.mapper

import com.wrecker.data.model.Pokemon
import com.wrecker.domain.model.Data
import com.wrecker.domain.model.Responses
import javax.inject.Inject

class PokemonEntityMapper @Inject constructor(

) : EntityMapper<Data, Pokemon> {
    override fun mapFromModel(model: Data): Pokemon {
        return Pokemon(
            id = model.id,
            name = model.name,
            subtypes = model.subtypes,
            level = model.level ?: "0",
            hp = model.hp,
            types = model.types,
            attacks = model.attacks,
            weaknesses = model.weaknesses,
            resistances = model.resistances?: arrayListOf(),
            images = model.images
        )
    }

}