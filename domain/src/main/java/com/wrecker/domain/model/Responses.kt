package com.wrecker.domain.model

import com.google.gson.annotations.SerializedName


data class Responses(
    @SerializedName("data")
    val data: ArrayList<Data> = ArrayList()
)