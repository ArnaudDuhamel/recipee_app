package com.example.recipee_app.screens

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.recipee_app.AppClass
import com.example.recipee_app.MockAppClass
import com.example.recipee_app.navigation.Screens

/*
   This is the function for the third page of the application displaying
   the name of the food item, its picture, a description and some recipes with
   the food item.

   This function always displays the information in the currentFood variable of
   the application class, it is the second page that is in charge of putting the
   information of the right food item in the currentFood variable.

   This was done to allow the second page to transfer information to the third
   page.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeScreen(navController: NavController, model: AppClass){

    val view = LocalView.current
    val window = (view.context as Activity).window

    val focusManager = LocalFocusManager.current

    val foodItem = model.getFoodVariable()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = foodItem.name,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    Color(window.statusBarColor)
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            focusManager.clearFocus()
                            navController.popBackStack(route = Screens.List.route, inclusive = false)
                        }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Icon to go back to the list page"
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(1.0f)
                //.verticalScroll(state = rememberScrollState(), enabled = true)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            Image(
                painter = painterResource(id = foodItem.picture),
                contentDescription = "Picture of ${foodItem.name}",
                modifier = Modifier
                    .fillMaxWidth(0.92f)
            )
            Spacer(
                //in this page, because the column was scrollable,
                //absolute values have been used instead of a percentage
                //of the container. Otherwise it was not working
                modifier = Modifier
                    .height(15.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(0.92f)
            ) {
                Text(
                    text = "Description",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            }
            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(0.92f)
            ) {
                Text(
                    text = foodItem.text,
                    textAlign = TextAlign.Justify
                )
            }
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
        }
    }
}

/*
   This is the function used for the preview. The reference to the
   main application class is replaced with a class that does not use
   the View Model class and that does not use context.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockRecipeScreen(navController: NavController, model: MockAppClass){

    val foodItem = model.getFoodVariable()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = foodItem.name,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack(route = Screens.List.route, inclusive = false)
                        }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Icon to go back to the list page"
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(1.0f)
                //.verticalScroll(state = rememberScrollState(), enabled = true)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            Image(
                painter = painterResource(id = foodItem.picture),
                contentDescription = "Picture of ${foodItem.name}",
                modifier = Modifier
                    .fillMaxWidth(0.92f)
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(0.92f)
            ) {
                Text(
                    text = "Description",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            }
            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(0.92f)
            ) {
                Text(
                    text = foodItem.text,
                    textAlign = TextAlign.Justify
                )
            }
            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )
        }
    }
}

/*
   This is the function previewing the third page of the application
 */
@Preview(showBackground = true)
@Composable
fun RecipeScreenPreview() {
    MaterialTheme {
        MockRecipeScreen(rememberNavController(), MockAppClass())
    }
}