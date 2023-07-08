package com.wrecker.cache.mapper

import com.wrecker.cache.entity.Pokemon
import javax.inject.Inject

class PokemonMapper @Inject constructor(

) : CacheMapper<Pokemon, com.wrecker.data.model.Pokemon>{

    override fun mapFromCache(type: Pokemon): com.wrecker.data.model.Pokemon {
        return com.wrecker.data.model.Pokemon(
            id = type.id,
            name = type.name,
            subtypes = type.subtypes,
            level = type.level.toString(),
            hp = type.hp.toString(),
            types = type.types,
            attacks = type.attacks,
            weaknesses = type.weaknesses,
            resistances = type.resistances,
            images = type.images
        )
    }

    override fun mapToCache(type: com.wrecker.data.model.Pokemon): Pokemon {
        return Pokemon(
            id = type.id,
            name = type.name,
            subtypes = type.subtypes,
            level = type.level.trim().toInt(),
            hp = type.hp.trim().toInt(),
            types = type.types,
            attacks = type.attacks,
            weaknesses = type.weaknesses,
            resistances = type.resistances,
            images = type.images
        )
    }
}