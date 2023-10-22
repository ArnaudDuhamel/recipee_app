package com.example.recipee_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.recipee_app.screens.HomeScreen

@Composable
fun NavGraph (navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route)
    {
        composable(route = Screens.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screens.List.route){

        }
        composable(route = Screens.Recipe.route){

        }
    }
}