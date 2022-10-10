package com.mr.misti.location.presentation.ui.search

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mr.misti.location.domain.model.Location
import com.mr.misti.location.presentation.ui.state.SearchState
import com.mr.misti.weather.design.theme.*

@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel
) {
    val uiState = searchViewModel.state.value
    val context = LocalContext.current
    searchViewModel.getLocations("")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientPrimary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TextFieldSearch{
            searchViewModel.getLocations(it)
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(uiState.locations) { location ->
                ItemWeather(location) {
                    Toast.makeText(context, "Onclick", Toast.LENGTH_SHORT).show()
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun Search(uiState: State<SearchState>) {

}

@Composable
fun ItemWeather(
    location: Location,
    onLocationSelected: (Location) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        //border = BorderStroke(width = 2.dp, color = Color.Blue),
        backgroundColor = yellow,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .clickable(
                    onClick = {
                        onLocationSelected(location)
                    }
                )

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(Icons.Filled.LocationOn, "", tint = blueDark)
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(text = location.city, color = Color.White, fontSize = 18.sp, fontFamily = bold)
                    Text(
                        text = location.country,
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = book
                    )
                }
            }
        }
    }

}


@Composable
fun TextFieldSearch(
    onValueChange: (String) -> Unit,
) {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 24.dp),
        shape = RoundedCornerShape(8.dp),
        trailingIcon = {
            Icon(Icons.Filled.Search, "", tint = yellow)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent, //hide the indicator
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            disabledTextColor = Color.Transparent,
            textColor = Color.Black
        ),
        placeholder = { Text(text = "Search...", color = Color.Gray) },
        singleLine = true
    )
}

/*@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreenPreview() {
    //Search(produceState())
}*/