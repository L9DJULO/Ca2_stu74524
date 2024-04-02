package com.stu74524.ca2_stu74524

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.route + "/0",
    ) {
        composable(route = Routes.FirstScreen.route)
        {
            Screen1(navController = navController)
        }
        composable(route = Routes.SecondScreen.route)
        {
            Screen2(navController = navController)
        }
        composable(route = Routes.ThirdScreen.route)
        {
            Screen3(navController = navController)
        }
        composable(route = Routes.FourthScreen.route){
            Screen4(navController = navController)
        }
        composable(route = Routes.HomeScreen.route + "/{seats}",
            arguments = listOf(
                navArgument("seats"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )){ entry ->
            entry.arguments?.let { HomeScreen(seats = it.getInt("seats"),navController = navController) }
        }
    }
}