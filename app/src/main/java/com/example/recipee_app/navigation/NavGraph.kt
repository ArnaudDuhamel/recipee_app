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

@Composable
fun NavGraph (navController: NavHostController, appClass: AppClass = viewModel()){
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
       // composable(route = Screens.Recipe.route){

       // }
    }
}