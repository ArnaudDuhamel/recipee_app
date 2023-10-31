package com.example.recipee_app

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import android.content.res.Resources
import kotlin.properties.Delegates

class AppClass(context: Context) : ViewModel() {

    private val recipesList = mutableStateListOf<Ingredient>()

    private var currentFood by Delegates.notNull<Ingredient>()

    init {
        val resources = context.resources
        recipesList.add(Ingredient(R.drawable.cabbage,"Cabbage",
            resources.getString(R.string.cabbage_description)
        ))
        recipesList.add(Ingredient(R.drawable.garlic,"Garlic",
           resources.getString(R.string.garlic_description)
        ))
        recipesList.add(Ingredient(R.drawable.ginger,"Ginger",
            resources.getString(R.string.ginger_description)
        ))
        recipesList.add(Ingredient(R.drawable.pepper,"Pepper",
            resources.getString(R.string.pepper_description)
        ))
        recipesList.add(Ingredient(R.drawable.rice,"Rice",
            resources.getString(R.string.rice_description)
        ))
    }

    fun getRecipesList(): List<Ingredient> {
        return recipesList
    }

    fun getFoodVariable(): Ingredient {
        return currentFood
    }

    fun setFoodVariable(food: Ingredient){
        currentFood = food
    }

}

data class Ingredient(val picture: Int, val name: String, val text: String)