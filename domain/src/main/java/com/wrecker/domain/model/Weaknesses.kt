package com.wrecker.domain.model

import com.google.gson.annotations.SerializedName


data class Weaknesses(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String

)