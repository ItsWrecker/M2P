package com.wrecker.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wrecker.domain.model.Images
import com.wrecker.domain.model.Attacks
import com.wrecker.domain.model.Resistances
import com.wrecker.domain.model.Weaknesses

@Entity
data class Pokemon(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val subtypes: ArrayList<String>,
    val level: Int = 0,
    val hp: Int = 0,
    val types: ArrayList<String>,
    val attacks: ArrayList<Attacks>,
    val weaknesses: ArrayList<Weaknesses>,
    val resistances: ArrayList<Resistances>,
    val images: Images
)
