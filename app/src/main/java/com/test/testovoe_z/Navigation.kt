package com.test.testovoe_z

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.testovoe_z.screens.Intro
import com.test.testovoe_z.screens.Login
import com.test.testovoe_z.screens.Payments
import com.test.testovoe_z.ApiService
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login screen") {
        composable("intro screen") {
            Intro(navController = navController)
        }
        composable("login screen") {
            Login(navController = navController)
        }
        composable("payments screen") {
            Payments(navController = navController)
        }
        // Add more destinations as needed
    }
}


