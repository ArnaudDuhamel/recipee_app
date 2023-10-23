package com.example.recipee_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
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

@Composable
fun ListScreen(navController: NavController, model: AppClass) {
    LazyColumn(
        horizontalAlignment = Alignment.Start
    ) {
        // here the notesList is changed into a list because the itemsIndexed
        // function takes a list
        itemsIndexed(model.getRecipesList()) { _, pair ->
            Row(
                modifier = Modifier
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // This text object contains the list item itself
                Image(
                    painter = painterResource(id = pair.first),
                    contentDescription = pair.second + " picture"
                )
                // The checkbox. Great care was take to look as much as possible
                // as the presented sketch
                Text(
                    text = pair.second
                )
            }

            HorizontalDivider(
                thickness = 1.dp
            )
        }
    }
}