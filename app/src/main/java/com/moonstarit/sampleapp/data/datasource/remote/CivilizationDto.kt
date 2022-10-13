package com.moonstarit.sampleapp.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class CivilizationDto(
    val id: Long,
    val name: String,
    val expansion: String,
    @SerializedName("army_type")
    val armyType: String,
    @SerializedName("unique_unit")
    val uniqueUnit: List<String>,
    @SerializedName("unique_tech")
    val uniqueTech: List<String>,
    @SerializedName("team_bonus")
    val teamBonus: String,
    @SerializedName("civilization_bonus")
    val civilizationBonus: List<String>,
)
