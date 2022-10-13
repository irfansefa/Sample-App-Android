package com.moonstarit.sampleapp.data.mapper

import com.moonstarit.sampleapp.data.datasource.remote.CivilizationDto
import com.moonstarit.sampleapp.domain.model.CivilizationData

fun CivilizationDto.toCivilizationData(): CivilizationData {
    return CivilizationData(
        id = this.id,
        name = this.name,
        expansion = this.expansion,
        armyType = this.armyType,
        uniqueTechs = this.uniqueTech,
        uniqueUnits = this.uniqueUnit,
        teamBonus = this.teamBonus,
        civilizationBonus = this.civilizationBonus
    )
}