package com.example.trashit

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trashit.screens.*



@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }

        composable(route = BottomBarScreen.Calendar.route) {
            CalendarScreen()
        }

        composable(route = Screen.WG_Create_Screen.route) {
            WG_Create_Screen()
        }

        composable(route = Screen.WG_Create_Screen.route) {
            //LoginUI(context = Context )
        }

    }
}