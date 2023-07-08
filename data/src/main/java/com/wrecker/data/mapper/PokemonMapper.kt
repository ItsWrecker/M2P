package com.wrecker.data.mapper

import com.wrecker.data.model.Pokemon
import com.wrecker.domain.model.Data
import javax.inject.Inject

class PokemonMapper @Inject constructor(
) : Mapper<Data, Pokemon> {
    override fun mapFromEntity(type: Data): Pokemon {
        return Pokemon(
            id = type.id,
            name = type.name,
            subtypes = type.subtypes,
            level = type.level ?: "0",
            hp = type.hp,
            types = type.types,
            attacks = type.attacks,
            weaknesses = type.weaknesses,
            resistances = type.resistances ?: arrayListOf(),
            images = type.images
        )
    }

    override fun mapToEntity(type: Pokemon): Data {
        return Data(
            id = type.id,
            name = type.name,
            subtypes = type.subtypes,
            level = type.level ?: "0",
            hp = type.hp,
            types = type.types,
            attacks = type.attacks,
            weaknesses = type.weaknesses,
            resistances = type.resistances,
            images = type.images
        )
    }
}