package com.wrecker.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wrecker.cache.converters.AttackConverter
import com.wrecker.cache.converters.ImagesTypeConverter
import com.wrecker.cache.converters.PokemonTypeConverter
import com.wrecker.cache.converters.ResistancesTypeConverter
import com.wrecker.cache.converters.WeaknessesTypeConverter
import com.wrecker.cache.dao.PokemonDao
import com.wrecker.cache.entity.Pokemon

@Database(
    entities = [Pokemon::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(
    AttackConverter::class,
    ImagesTypeConverter::class,
    PokemonTypeConverter::class,
    ResistancesTypeConverter::class,
    WeaknessesTypeConverter::class
)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao
}