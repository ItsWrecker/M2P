package com.wrecker.cache.entity

import kotlinx.serialization.Serializable

@Serializable
data class Cache(
    val cacheTimestamp: Long =0
)