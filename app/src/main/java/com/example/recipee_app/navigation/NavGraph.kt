package com.example.recipee_app.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.recipee_app.AppClass
import com.example.recipee_app.screens.HomeScreen
import com.example.recipee_app.screens.ListScreen
import com.example.recipee_app.screens.RecipeScreen

/*
Navigation graph to navigate between the different pages.

It has a Navigation controller that creates the navigation stack
and actually allows the navigation

It also contains an AppClass, which is the main class used by the
application to store information
*/

@Composable
fun NavGraph (navController: NavHostController, appClass: AppClass){
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route)
    {
        composable(route = Screens.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screens.List.route){
            ListScreen(navController, appClass)
        }
        composable(route = Screens.Recipe.route){
            RecipeScreen(navController, appClass)
       }
    }
}