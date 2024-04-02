package com.stu74524.ca2_stu74524

sealed class Routes(val route: String) {
    object FirstScreen : Routes("first_screen")
    object SecondScreen : Routes("second_screen")
    object ThirdScreen : Routes("third_screen")
    object FourthScreen : Routes("fourth_screen")
    object HomeScreen : Routes("Home_screen")
}