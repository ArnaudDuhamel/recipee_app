package com.example.recipee_app

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class AppClass : ViewModel() {

    private val recipesList = mutableStateListOf<Pair<Int,String>>()
    init {
        recipesList.add(Pair(R.drawable.cabbage,"Cabbage"))
        recipesList.add(Pair(R.drawable.garlic,"Garlic"))
        recipesList.add(Pair(R.drawable.ginger,"Ginger"))
        recipesList.add(Pair(R.drawable.pepper,"Pepper"))
        recipesList.add(Pair(R.drawable.rice,"Rice"))
    }

    fun getRecipesList(): List<Pair<Int, String>> {
        return recipesList
    }

}