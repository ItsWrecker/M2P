package com.wrecker.remote.mapper

interface EntityMapper<M, E> {

    fun mapFromModel(model: M): E
}