package com.example.recipee_app.navigation
sealed class Screens(val route: String) {
    object Home: Screens("home_screen")
    object List: Screens("list_screen")
    object Recipe: Screens("recipe_screen")
}