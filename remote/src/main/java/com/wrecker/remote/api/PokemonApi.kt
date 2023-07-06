package com.wrecker.remote.api

import com.wrecker.domain.model.Responses
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("v2/cards")
    suspend fun getPokemonData(
        @Query("pageSize")
        page: Int
    ): Response<Responses>
}