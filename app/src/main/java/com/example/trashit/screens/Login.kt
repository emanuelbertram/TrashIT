package com.example.trashit.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.trashit.BottomBarScreen


@Composable
fun LoginUI(context: Context){
    val navController = rememberNavController()

    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text="Login",
            textAlign = TextAlign.Left,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text("Enter your mail") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text("Enter your password") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )

        OutlinedButton(
            onClick = {
                logged(email,password,context)
                if(richtig(email,password,context)) navController.navigate(BottomBarScreen.Home.route)
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp,top = 10.dp)) {
            Text(text = "Login",
                textAlign = TextAlign.Center)

        }
    }
}

fun richtig(email: String, password: String, context: Context) : Boolean{
    return email=="emanuel" && password == "1234"
}

fun logged(email: String, password: String, context: Context) {
    if(email=="emanuel" && password == "1234"){
        Toast.makeText(context,"Logged In Successfully", Toast.LENGTH_SHORT).show()


    }else
    {
        Toast.makeText(context,"Logged In Failed", Toast.LENGTH_SHORT).show()
    }
}

