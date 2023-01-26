package com.example.trashit



sealed class Screen(val route : String) {
    object WG_Create_Screen : Screen("wg_create")


}