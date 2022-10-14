package com.moonstarit.sampleapp.ui.navigation

interface NavigationDestinations {
    val route: String
}

object Civilizations : NavigationDestinations {
    override val route: String = "civilizations"
}

object CivilizationDetail : NavigationDestinations {
    override val route: String = "civilizationDetail"
}