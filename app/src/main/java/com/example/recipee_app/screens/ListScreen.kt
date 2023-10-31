package com.example.recipee_app.screens

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipee_app.AppClass
import com.example.recipee_app.R
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.recipee_app.FoodItem
import com.example.recipee_app.MockAppClass
import com.example.recipee_app.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController, model: AppClass) {

    val view = LocalView.current
    val window = (view.context as Activity).window

    val focusManager = LocalFocusManager.current

    val inputValue = remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Gordon's food list",
                        fontWeight = FontWeight.Bold,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    Color(window.statusBarColor)
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            focusManager.clearFocus()
                            navController.popBackStack(route = Screens.Home.route, inclusive = false)
                        }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Icon to go back to main page"
                        )
                    }
                }
                )
        },
        modifier = Modifier
            .fillMaxWidth()
    ) { paddingValues ->

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(paddingValues)
        ) {
            TextField(
                value = inputValue.value,
                onValueChange = {
                    inputValue.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = TextUnit.Unspecified,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Left
                ),
                maxLines = 1,
                singleLine = true,
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
                trailingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                }
            )

            LazyColumn(
                horizontalAlignment = Alignment.Start
            ) {
                // here the notesList is changed into a list because the itemsIndexed
                // function takes a list

                if (inputValue.value.text.isEmpty()) {
                    itemsIndexed(model.getRecipesList()) { _, food ->

                        drawListElement(food, navController, model)

                    }
                } else {
                    itemsIndexed(model.getRecipesList()) { _, food ->

                        if(food.name.lowercase().startsWith(inputValue.value.text.lowercase())){
                            drawListElement(food, navController, model)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun drawListElement(food: FoodItem, navController: NavController, model: AppClass) {

    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(1.0f)
            .clickable {
                model.setFoodVariable(food)
                navController.navigate(Screens.Recipe.route)
                       },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // This text object contains the list item itself
        Image(
            painter = painterResource(id = food.picture),
            contentDescription = food.name + " picture",
            modifier = Modifier
                .fillMaxWidth(0.25f)
                .fillMaxHeight(1.0f)
        )

        Spacer(modifier = Modifier.width(7.5.dp))

        // The checkbox. Great care was take to look as much as possible
        // as the presented sketch
        Text(
            text = food.name,
            fontSize = 20.sp
        )
    }

    HorizontalDivider(
        thickness = 1.dp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockListScreen(navController: NavController, model: MockAppClass) {

    val inputValue = remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Gordon's food list",
                        fontWeight = FontWeight.Bold,
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack(route = Screens.Home.route, inclusive = false)
                        }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Icon to go back to main page"
                        )
                    }
                }
            )
        },
        modifier = Modifier
            .fillMaxWidth()
    ) { paddingValues ->

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(paddingValues)
        ) {
            TextField(
                value = inputValue.value,
                onValueChange = {
                    inputValue.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = TextUnit.Unspecified,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Left
                ),
                maxLines = 1,
                singleLine = true,
                trailingIcon = {
                    Icon(
                        Icons.Filled.Search,
                        contentDescription = "Search"
                    )
                }
            )

            LazyColumn(
                horizontalAlignment = Alignment.Start
            ) {
                // here the notesList is changed into a list because the itemsIndexed
                // function takes a list

                if (inputValue.value.text.isEmpty()) {
                    itemsIndexed(model.getRecipesList()) { _, food ->

                        MockdrawListElement(food, navController, model)

                    }
                } else {
                    itemsIndexed(model.getRecipesList()) { _, food ->

                        if(food.name.lowercase().startsWith(inputValue.value.text.lowercase())){
                            MockdrawListElement(food, navController, model)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MockdrawListElement(food: FoodItem, navController: NavController, model: MockAppClass) {

    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(1.0f)
            .clickable {
                model.setFoodVariable(food)
                navController.navigate(Screens.Recipe.route)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // This text object contains the list item itself
        Image(
            painter = painterResource(id = food.picture),
            contentDescription = food.name + " picture",
            modifier = Modifier
                .fillMaxWidth(0.25f)
                .fillMaxHeight(1.0f)
        )

        Spacer(modifier = Modifier.width(7.5.dp))

        // The checkbox. Great care was take to look as much as possible
        // as the presented sketch
        Text(
            text = food.name,
            fontSize = 20.sp
        )
    }

    HorizontalDivider(
        thickness = 1.dp
    )
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    MaterialTheme {
        MockListScreen(rememberNavController(), MockAppClass())
    }
}