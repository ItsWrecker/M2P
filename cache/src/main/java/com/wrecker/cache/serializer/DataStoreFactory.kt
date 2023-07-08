package com.wrecker.cache.serializer

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.wrecker.cache.entity.Cache

object DataStoreFactory {

    private val Context.dataStore by dataStore("cache.json", CacheSerializer)
    fun create(context: Context): DataStore<Cache> {
        return context.dataStore
    }
}