package com.example.recipee_app

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

open class AppClass(context: Context) : ViewModel() {

    private val recipesList = mutableStateListOf<FoodItem>()

    private var currentFood by Delegates.notNull<FoodItem>()

    init {
        val resources = context.resources
        recipesList.add(FoodItem(R.drawable.cabbage,"Cabbage",
            resources.getString(R.string.cabbage_description)
        ))
        recipesList.add(FoodItem(R.drawable.garlic,"Garlic",
            resources.getString(R.string.garlic_description)
        ))
        recipesList.add(FoodItem(R.drawable.ginger,"Ginger",
            resources.getString(R.string.ginger_description)
        ))
        recipesList.add(FoodItem(R.drawable.pepper,"Pepper",
            resources.getString(R.string.pepper_description)
        ))
        recipesList.add(FoodItem(R.drawable.rice,"Rice",
            resources.getString(R.string.rice_description)
        ))
    }

    fun getRecipesList(): List<FoodItem> {
        return recipesList
    }

    fun getFoodVariable(): FoodItem {
        return currentFood
    }

    fun setFoodVariable(food: FoodItem){
        currentFood = food
    }

}

class MockAppClass {

    private val recipesList = mutableStateListOf<FoodItem>()

    private var currentFood by Delegates.notNull<FoodItem>()
    init {
        currentFood = FoodItem(R.drawable.ginger,"Ginger",
            "Ginger (Zingiber officinale) is a flowering plant whose rhizome, ginger root or ginger, is widely used as a spice and a folk medicine. It is a herbaceous perennial which grows annual pseudostems (false stems made of the rolled bases of leaves) about one meter tall, bearing narrow leaf blades. The inflorescences bear flowers having pale yellow petals with purple edges, and arise directly from the rhizome on separate shoots. Text taken on Wikipedia.\\n\\nSome recipes with ginger as a main ingredient are, among others, Lamb tomato and sweet spices, Nutty Chicken Curry and Szechuan Beef."
        )

        recipesList.add(FoodItem(R.drawable.cabbage,"Cabbage",
            "Cabbage, comprising several cultivars of Brassica oleracea, is a leafy green, red (purple), or white (pale green) biennial plant grown as an annual vegetable crop for its dense-leaved heads. It is descended from the wild cabbage (B. oleracea var. oleracea), and belongs to the \\\"cole crops\\\" or brassicas, meaning it is closely related to broccoli and cauliflower (var. botrytis); Brussels sprouts (var. gemmifera); and Savoy cabbage (var. sabauda). Text taken from Wikipedia.\\n\\nSome recipes with cabbage as a main ingredient are, among others, Crispy Sausages and Greens, Corned Beef and Cabbage and Ham hock colcannon."
        ))
        recipesList.add(FoodItem(R.drawable.garlic,"Garlic",
                "Garlic (Allium sativum) is a species of bulbous flowering plant in the genus Allium. Its close relatives include the onion, shallot, leek, chive, Welsh onion, and Chinese onion. It is native to South Asia, Central Asia and northeastern Iran and has long been used as a seasoning worldwide, with a history of several thousand years of human consumption and use. It was known to ancient Egyptians and has been used as both a food flavoring and a traditional medicine. China produces 76% of the world\\'s supply of garlic. Text taken on Wikipedia.\\n\\nSome recipes with garlic as a main ingredient are, among others, Chicken Alfredo Primavera, Chicken Basquaise and Croatian Bean Stew."
        ))
        recipesList.add(FoodItem(R.drawable.ginger,"Ginger",
                "Ginger (Zingiber officinale) is a flowering plant whose rhizome, ginger root or ginger, is widely used as a spice and a folk medicine. It is a herbaceous perennial which grows annual pseudostems (false stems made of the rolled bases of leaves) about one meter tall, bearing narrow leaf blades. The inflorescences bear flowers having pale yellow petals with purple edges, and arise directly from the rhizome on separate shoots. Text taken on Wikipedia.\\n\\nSome recipes with ginger as a main ingredient are, among others, Lamb tomato and sweet spices, Nutty Chicken Curry and Szechuan Beef."
        ))
        recipesList.add(FoodItem(R.drawable.pepper,"Pepper",
            "Black pepper (Piper nigrum) is a flowering vine in the family Piperaceae, cultivated for its fruit (the peppercorn), which is usually dried and used as a spice and seasoning. The fruit is a drupe (stonefruit) which is about 5 mm (0.20 in) in diameter (fresh and fully mature), dark red, and contains a stone which encloses a single pepper seed. Peppercorns and the ground pepper derived from them may be described simply as pepper, or more precisely as black pepper (cooked and dried unripe fruit), green pepper (dried unripe fruit), or white pepper (ripe fruit seeds).Text taken on Wikipedia.\\n\\nSome recipes with pepper as a main ingredient are, among others, Crispy Eggplant, Mediterranean Pasta Salad and Breakfast Potatoes."
        ))
        recipesList.add(FoodItem(R.drawable.rice,"Rice",
                "Rice is the seed of the grass species Oryza sativa (Asian rice) or, less commonly, O. glaberrima (African rice). The name wild rice is usually used for species of the genera Zizania and Porteresia, both wild and domesticated, although the term may also be used for primitive or uncultivated varieties of Oryza. Text taken on Wikipedia.\\n\\nSome recipes with rice as a main ingredient are, among others, Salmon Prawn Risotto, Stuffed Lamb Tomatoes and Egyptian Fatteh."
        ))
    }

    fun getRecipesList(): List<FoodItem> {
        return recipesList
    }

    fun getFoodVariable(): FoodItem {
        return currentFood
    }

    fun setFoodVariable(food: FoodItem){
        currentFood = food
    }

}

data class FoodItem(val picture: Int, val name: String, val text: String)