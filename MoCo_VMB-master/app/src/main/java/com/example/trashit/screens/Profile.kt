package com.example.trashit.screens

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import java.net.URI
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.trashit.R


@Composable
fun ProfileScreen(){
    val notification = rememberSaveable { mutableStateOf("")}
    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }

    var name by rememberSaveable { mutableStateOf("default name")}
    var username by rememberSaveable { mutableStateOf("default username")}
    var bio by rememberSaveable { mutableStateOf("default bio")}

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(8.dp)){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Cancel",
                modifier = Modifier.clickable { notification.value = "Cancelled" })
            Text(
                text = "Save",
                modifier = Modifier.clickable { notification.value = "Profile updatet" })
        }
        ProfileImage()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Name", modifier = Modifier.width(100.dp))
            TextField(
                value = name,
                onValueChange = {name = it},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Username", modifier = Modifier.width(100.dp))
            TextField(
                value = username,
                onValueChange = {username = it},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black
                )
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            verticalAlignment = Alignment.Top){
            Text(
                text = "Bio",
                modifier = Modifier
                    .width(100.dp)
                    .padding(top = 8.dp))
            TextField(
                value = bio,
                onValueChange = {bio = it},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black
                ),
                singleLine = false,
                modifier = Modifier.height(150.dp)
            )
        }
    }
}

@Composable
fun ProfileImage() {
    val imageUri = rememberSaveable { mutableStateOf("")}
    val painter = rememberImagePainter(
        if(imageUri.value.isEmpty()) {
            R.drawable.ic_user
        } else
            imageUri.value
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ){
            uri : Uri? ->
        uri?.let { imageUri.value = it.toString() }
    }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
        Text(text = "Change profile picture")
    }
}