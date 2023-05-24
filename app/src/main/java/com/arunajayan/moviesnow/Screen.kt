package com.arunajayan.moviesnow

sealed class Screen (val route:String){
    object Home:Screen(route = "home_screen")
    object Login:Screen(route = "login")
    object Signup:Screen(route="signup")
}