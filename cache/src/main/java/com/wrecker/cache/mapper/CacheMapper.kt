package com.wrecker.cache.mapper

interface CacheMapper<T, V> {
    fun mapFromCache(type: T): V
    fun mapToCache(type: V): T
}