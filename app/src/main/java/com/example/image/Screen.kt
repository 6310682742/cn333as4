package com.example.image

sealed class Screen(val route: String) {
    object Home:Screen(route = "home_screen")
    object Image:Screen(route="image_screen/{width}/{height}/{search}")
}