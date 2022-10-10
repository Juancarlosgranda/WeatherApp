package com.mr.misti.weather.presentation.ui.forecast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.mr.misti.weather.design.theme.*
import com.mr.misti.weather.presentation.model.ForecastDayModel

@Composable
fun ForecastScreen(
    location: String,
    forecastViewModel: ForecastViewModel = hiltViewModel()
) {
    Forecast(location, forecastViewModel)
}

@Composable
fun Forecast(location: String, forecastViewModel: ForecastViewModel) {
    val uiState = forecastViewModel.state.value
    forecastViewModel.getForecasts(location)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientPrimary)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Icon(Icons.Filled.LocationOn, "", tint = yellowDarkVariant)
        Text(
            text = uiState.location?.city.orEmpty(),
            color = Color.White,
            fontSize = 32.sp,
            fontFamily = bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(color = yellow),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = uiState.location?.country.orEmpty(),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = book,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text(
                text = uiState.currentWeather?.tempCelsius.orEmpty(),
                color = Color.White,
                fontSize = 100.sp,
                fontFamily = black,
                textAlign = TextAlign.Center
            )
            Text(
                text = "°C",
                color = Color.White,
                fontSize = 30.sp,
                fontFamily = black,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Text(
            text = uiState.currentWeather?.condition.orEmpty(),
            color = Color.White,
            fontSize = 32.sp,
            fontFamily = bold,
            modifier = Modifier.padding(top = 16.dp)
        )
        Image(
            painter = rememberAsyncImagePainter(uiState.currentWeather?.iconUrl.orEmpty()),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(72.dp)
                .padding(top = 24.dp)
        )
        Text(
            text = uiState.location?.localtime.orEmpty(),
            color = yellow,
            fontSize = 18.sp,
            fontFamily = book,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "3-day forecast detail:",
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = book,
            modifier = Modifier.padding(top = 24.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(modifier = Modifier.fillMaxSize()) {
            uiState.forecastDays.forEach {
                ItemForecast(it)
            }
           /* items(uiState.forecastDays) { forecastDay ->
                ItemForecast(forecastDay)
            }*/
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ItemForecast(forecastDay: ForecastDayModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = rememberAsyncImagePainter(forecastDay.iconUrl),
                contentDescription = "image",
                modifier = Modifier
                    .size(width = 48.dp, height = 48.dp)
                    .padding(end = 16.dp)
            )
            Text(
                text = "${forecastDay.dateFormat} - ${forecastDay.condition}",
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = book,
            )
        }
        Text(
            text = "${forecastDay.avgTempCelsius}°C",
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = bold,
        )
    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ForecastScreenPreview() {
    Forecast("", viewModel())
}