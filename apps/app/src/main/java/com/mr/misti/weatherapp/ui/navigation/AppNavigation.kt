package com.mr.misti.weatherapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mr.misti.core.navigation.AppScreens
import com.mr.misti.location.presentation.ui.search.SearchScreen
import com.mr.misti.weather.presentation.ui.forecast.ForecastScreen
import com.mr.misti.weatherapp.ui.screens.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreens.SearchScreen.route) {
            SearchScreen(navController)
        }
        composable("${AppScreens.ForecastScreen.route}/{location}") {
            ForecastScreen( it.arguments?.getString("location").orEmpty())
        }
    }
}