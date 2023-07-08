package com.wrecker.domain.model

import com.google.gson.annotations.SerializedName


data class Attacks(
    @SerializedName("name")
    val name: String,
    @SerializedName("cost")
    val cost: ArrayList<String>,
    @SerializedName("convertedEnergyCost")
    val convertedEnergyCost: Int,
    @SerializedName("damage")
    val damage: String,
    @SerializedName("text")
    val text: String
)