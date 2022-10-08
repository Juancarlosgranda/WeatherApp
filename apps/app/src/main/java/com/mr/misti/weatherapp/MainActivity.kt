package com.mr.misti.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.mr.misti.weatherapp.ui.theme.WeatherAppTheme
import com.mr.misti.weatherapp.ui.theme.book

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(colorResource(id = R.color.teal_200))
                            .wrapContentSize(Alignment.Center)
                    ) {
                        Greeting("Android")
                        Text("Android with font", fontFamily = book, color = Color.White)

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",  color = Color.White)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherAppTheme {
        Greeting("Android")
    }
}