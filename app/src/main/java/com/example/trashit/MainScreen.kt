package com.example.trashit

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        BottomNavGraph(navController = navController)
        Spacer(modifier = Modifier.height(8.dp))
        Wg_Create_Button(navController = navController)
    }
}

@Composable
fun Wg_Create_Button(navController: NavHostController) {
    Button(
        modifier = Modifier,
        onClick = {
            navController.navigate(Screen.WG_Create_Screen.route) {
                launchSingleTop = true
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                restoreState = true
            }

        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)

    ){
        Image(painterResource(id = R.drawable.ic_people),
            contentDescription ="Cart button icon",
            modifier = Modifier.size(20.dp))

        Text(text = "WG erstellen", Modifier.padding(start = 10.dp), color = Color.White)

    }

}


@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Profile,
        BottomBarScreen.Settings,
        BottomBarScreen.Calendar
    )

    //observing navBackStackEntry + notifies when a change appears
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}


@Composable
//Extension Function on a rowscope
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                launchSingleTop = true
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                restoreState = true

            }
        }
    )
}



