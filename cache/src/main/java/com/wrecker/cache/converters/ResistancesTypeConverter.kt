package com.wrecker.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wrecker.domain.model.Resistances
import com.wrecker.domain.model.Weaknesses

class ResistancesTypeConverter {


    @TypeConverter
    fun fromSource(source: String): ArrayList<Resistances> {
        val type = object : TypeToken<ArrayList<Resistances>>() {}.type
        return Gson().fromJson(source, type)
    }

    @TypeConverter
    fun toSource(value: ArrayList<Resistances>): String {
        return Gson().toJson(value)
    }
}