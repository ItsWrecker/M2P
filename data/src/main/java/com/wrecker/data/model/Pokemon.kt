package com.wrecker.data.model

import com.wrecker.domain.model.Attacks
import com.wrecker.domain.model.Images
import com.wrecker.domain.model.Resistances
import com.wrecker.domain.model.Weaknesses

data class Pokemon(
    val id: String,
    val name: String,
    val subtypes: String,
    val level: String,
    val hp: String,
    val types: ArrayList<String>,
    val attacks: ArrayList<Attacks>,
    val weaknesses: ArrayList<Weaknesses>,
    val resistances: ArrayList<Resistances>,
    val images: Images
)
