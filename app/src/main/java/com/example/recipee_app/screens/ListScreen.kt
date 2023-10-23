package com.example.recipee_app.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ListScreen(navController: NavController, ) {
    LazyColumn {
        // Add a single item
        item {
            Text(text = "First item")
        }

        // Add 5 items
        items(5) { index ->
            Text(text = "Item: $index")
        }

        // Add another single item
        item {
            Text(text = "Last item")
        }
    }
}