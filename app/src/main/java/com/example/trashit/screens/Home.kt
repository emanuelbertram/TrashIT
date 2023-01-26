package com.example.trashit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trashit.MainActivity.Companion.RToken



@Composable
fun HomeScreen() {
    Column(modifier = Modifier
        .padding(8.dp)){

        Text(
            text = "HOME",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        /*
        Text(
            text = "Registration Token: $RToken",
            modifier = Modifier)
         */

        TextField(
            value = RToken,
            onValueChange = {RToken = it},
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                textColor = Color.Black
            )
        )

    }

/*
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "HOME",
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "Registration Token: $RToken",
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }

 */



}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}


