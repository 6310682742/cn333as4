package com.example.image

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import kotlin.reflect.typeOf

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Image.route,
            arguments = listOf(navArgument("width") {
                type = NavType.IntType
            },
                navArgument("height") {
                    type = NavType.IntType
                },
                navArgument("search") {
                    type = NavType.StringType
                })
            
        ) {
            val width = it.arguments?.getInt("width")
            val height = it.arguments?.getInt("height")
            val search = it.arguments?.getString("search")

            Log.d("Args ",width.toString())
            ImageScreen(navController = navController,width=width, height = height, search = search)
        }
    }
}