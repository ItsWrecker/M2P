package com.wrecker.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wrecker.domain.model.Weaknesses

class WeaknessesTypeConverter {


    @TypeConverter
    fun fromSource(source: String): ArrayList<Weaknesses> {
        val type = object : TypeToken<ArrayList<Weaknesses>>() {}.type
        return Gson().fromJson(source, type)
    }

    @TypeConverter
    fun toSource(value: ArrayList<Weaknesses>): String {
        return Gson().toJson(value)
    }
}