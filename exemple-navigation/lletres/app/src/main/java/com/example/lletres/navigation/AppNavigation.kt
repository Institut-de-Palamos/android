package com.example.lletres.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lletres.ui.HomeScreen
import com.example.lletres.ui.LletraScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    )
    {
        composable(route = "home") {
            HomeScreen(onClickLletra = {
                navController.navigate(it)
            })
        }

        for (lletra in 'a'..'z') {
            composable(route = lletra.toString()) {
                LletraScreen(
                    lletra = lletra.toString(),
                    onBackButton = {
                        navController.navigate("home")
                    })
            }
        }
    }
}