package com.mr.misti.core.navigation


sealed class AppScreens(val route: String) {
    object SplashScreen: AppScreens("splash_screen")
    object SearchScreen: AppScreens("search_screen")
}