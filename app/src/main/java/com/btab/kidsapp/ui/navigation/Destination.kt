package com.btab.kidsapp.ui.navigation

sealed class Destination(
    val route: String
) {
    object HomeScreen: Destination("homeScreen")
}