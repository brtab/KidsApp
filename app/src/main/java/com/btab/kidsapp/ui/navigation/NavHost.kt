package com.btab.kidsapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.btab.kidsapp.ui.screen.GameSelectionScreen
import com.btab.kidsapp.ui.screen.HomeScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.HomeScreen.route) {
        composable(Destination.HomeScreen.route) {
            HomeScreen(
                navController = navController
                , navGameSelectionScreen = { gameSelected ->
                    navController.navigate(Destination.GameSelectionScreen.createRoute(gameSelected))
                }
            )
        }
        composable(Destination.GameSelectionScreen.route) { navBackStackEntry ->
            val gameSelected = navBackStackEntry.arguments?.getString("gameSelected")
            GameSelectionScreen(
                gameSelected = gameSelected!!,
                navController = navController
            )
        }
    }
}