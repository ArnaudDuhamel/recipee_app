package com.example.recipee_app

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class AppClass : ViewModel() {

    private val recipesList = mutableStateListOf<Pair<String,String>>()

}