package com.example.recipee_app

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import android.content.res.Resources
import kotlin.properties.Delegates

class AppClass : ViewModel() {

    private val recipesList = mutableStateListOf<Ingredient>()

    private var foodPicture by Delegates.notNull<Int>()

    private var foodName by Delegates.notNull<String>()

    private var foodText by Delegates.notNull<String>()

    init {
        recipesList.add(Ingredient(R.drawable.cabbage,"Cabbage",
            Resources.getSystem().getString(R.string.cabbage_description)
        ))
        recipesList.add(Ingredient(R.drawable.garlic,"Garlic",
            Resources.getSystem().getString(R.string.garlic_description)))
        recipesList.add(Pair(R.drawable.ginger,"Ginger"))
        recipesList.add(Pair(R.drawable.pepper,"Pepper"))
        recipesList.add(Pair(R.drawable.rice,"Rice"))
    }

    fun getRecipesList(): List<Pair<Int, String>> {
        return recipesList
    }

}

data class Ingredient(val picture: Int, val name: String, val text: String)