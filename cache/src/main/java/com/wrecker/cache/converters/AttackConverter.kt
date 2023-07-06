package com.wrecker.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import com.wrecker.domain.model.Attacks

class AttackConverter {

    @TypeConverter
    fun fromSource(source: String): ArrayList<Attacks> {
        val type = object : TypeToken<ArrayList<Attacks>>() {}.type
        return Gson().fromJson(source, type)
    }

    @TypeConverter
    fun toSource(source: ArrayList<Attacks>): String {
        return Gson().toJson(source)
    }
}