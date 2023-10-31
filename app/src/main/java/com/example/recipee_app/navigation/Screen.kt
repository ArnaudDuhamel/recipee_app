package com.example.recipee_app.navigation

/*
    This is the sealed class that designates the different
    branches to be used by the navigation tree
 */
sealed class Screens(val route: String) {
    object Home: Screens("home_screen")
    object List: Screens("list_screen")
    object Recipe: Screens("recipe_screen")
}