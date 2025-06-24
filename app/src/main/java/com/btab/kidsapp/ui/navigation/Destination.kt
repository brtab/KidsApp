package com.btab.kidsapp.ui.navigation

import com.btab.kidsapp.model.GameName

sealed class Destination(
    val route: String
) {
    object HomeScreen: Destination("homeScreen")
    object GameSelectionScreen: Destination("gameSelectionScreen/{gameSelected}") {
        fun createRoute(gameSelected: String) = "gameSelectionScreen/${gameSelected}"
    }
}