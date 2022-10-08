package com.mr.misti.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mr.misti.weatherapp.R
import com.mr.misti.weatherapp.ui.navigation.AppScreens
import com.mr.misti.weatherapp.ui.theme.bold
import com.mr.misti.weatherapp.ui.theme.gradientPrimary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(5000)
        navController.popBackStack()
        navController.navigate(AppScreens.MainScreen.route)
    }
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientPrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = "Logo Weather",
            modifier = Modifier.size(150.dp, 150.dp)
        )
        Text(text = "Welcome!", color = Color.White, fontSize = 30.sp, fontFamily = bold)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}