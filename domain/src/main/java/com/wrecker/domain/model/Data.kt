package com.wrecker.domain.model

import com.google.gson.annotations.SerializedName


data class Data(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("subtypes")
    val subtypes: ArrayList<String>,
    @SerializedName("level")
    val level: String? = null,
    @SerializedName("hp")
    val hp: String,
    @SerializedName("types")
    val types: ArrayList<String>,
    @SerializedName("attacks")
    val attacks: ArrayList<Attacks>,
    @SerializedName("weaknesses")
    val weaknesses: ArrayList<Weaknesses>,
    @SerializedName("resistances")
    val resistances: ArrayList<Resistances>?=null,
    @SerializedName("images")
    val images: Images
)