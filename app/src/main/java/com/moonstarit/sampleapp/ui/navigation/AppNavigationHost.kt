package com.moonstarit.sampleapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moonstarit.sampleapp.ui.civilizations.CivilizationDetailScreen
import com.moonstarit.sampleapp.ui.civilizations.CivilizationsScreen
import com.moonstarit.sampleapp.ui.navigation.CivilizationDetail
import com.moonstarit.sampleapp.ui.navigation.Civilizations

@Composable
fun AppNavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Civilizations.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Civilizations.route) {
            CivilizationsScreen(
                onClickCivilization = { civilizationId ->
                    navController.navigate("${CivilizationDetail.route}/$civilizationId")
                }
            )
        }
        composable(
            route = CivilizationDetail.totalRoute,
            arguments = listOf(navArgument(CivilizationDetail.civilizationId) {
                type = NavType.LongType
            })
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val civilizationId = arguments.getLong(CivilizationDetail.civilizationId)
            CivilizationDetailScreen(
                civilizationId,
                { navController.navigateUp() }
            )
        }
    }

}