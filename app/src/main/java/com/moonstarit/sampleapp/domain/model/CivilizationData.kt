package com.moonstarit.sampleapp.domain.model

data class CivilizationData(
    val id: Long,
    val name: String,
    val expansion: String,
    val armyType: String,
    val uniqueUnits: List<String>,
    val uniqueTechs: List<String>,
    val teamBonus: String,
    val civilizationBonus: List<String>,
)
