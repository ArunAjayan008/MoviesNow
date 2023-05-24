package com.arunajayan.moviesnow.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arunajayan.moviesnow.Screen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination =Screen.Home.route ){
        composable(
            route = Screen.Home.route
        ){
            Home()
        }
        composable(
            route = Screen.Login.route
        ){
            Login()
        }
    }
}