package com.wrecker.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PokemonTypeConverter {

    @TypeConverter
    fun fromSource(source: String): ArrayList<String> {
        val type = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(source, type)
    }

    @TypeConverter
    fun toSource(value: ArrayList<String>): String {
        return Gson().toJson(value)
    }
}