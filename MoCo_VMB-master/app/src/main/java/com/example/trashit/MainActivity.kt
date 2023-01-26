package com.example.trashit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.trashit.screens.RegistrationScreen
import com.example.trashit.ui.theme.PrimaryColor
import com.example.trashit.ui.theme.TrashITTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TrashITTheme {
                Surface(color = PrimaryColor,
                    modifier = Modifier.fillMaxSize())
                {
                    //MainScreen()
                    //LoginUI()
                    RegistrationScreen()
                    //ForgotPasswordScreen()
                    //SettingsScreen()
                }
            }
        }
    }
}

