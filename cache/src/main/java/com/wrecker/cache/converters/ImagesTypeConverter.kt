package com.wrecker.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wrecker.domain.model.Images
import com.wrecker.domain.model.Weaknesses

class ImagesTypeConverter {

    @TypeConverter
    fun fromSource(source: String): Images {
        val type = object : TypeToken<Images>() {}.type
        return Gson().fromJson(source, type)
    }

    @TypeConverter
    fun toSource(value: Images): String {
        return Gson().toJson(value)
    }
}