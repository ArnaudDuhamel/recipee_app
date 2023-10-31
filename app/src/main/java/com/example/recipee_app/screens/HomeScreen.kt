package com.example.recipee_app.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.recipee_app.R
import com.example.recipee_app.navigation.Screens

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(1.0f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(
            modifier = Modifier
                .fillMaxHeight(0.025f)
        )
        Image(
            painter = painterResource(id = R.drawable.gordon_ramsay_portrait),
            contentDescription = stringResource(R.string.portrait_picture_of_gordon_ramsay),
            modifier = Modifier
                .fillMaxWidth(0.95f)
        )
        Spacer(
            modifier = Modifier
                .fillMaxHeight(0.03f)
        )
        Button(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .padding(top = 5.dp)
                .fillMaxWidth(0.925f),
            onClick = {
                navController.navigate(Screens.List.route)
            }
        ) {
            Text(
                text = "Gordon Ramsay",
                modifier = Modifier
                    .padding(top = 5.dp,
                            bottom = 9.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(rememberNavController())
    }
}