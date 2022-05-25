package com.example.countriesapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.countriesapp.model.CountryRepo
import com.example.countriesapp.ui.theme.CountriesAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewCountryDeatilsScreen(countryRepo: CountryRepo) {
    CountriesAppTheme() {
        CountryDetails(navController = rememberNavController(), countryRepo)
    }
}
@Composable
fun CountryDetails(navController: NavHostController, countryRepo: CountryRepo) {

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp, 20.dp),
    ) {

        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = rememberImagePainter(data = countryRepo.flags.png),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .align(alignment = Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Country Name : ${countryRepo.name.common}",
            style = MaterialTheme.typography.h5,
        )
        Text(
            text = "Population : ${countryRepo.population} ",
            style = MaterialTheme.typography.h5,
        )
        Text(
            text = "Area : ${countryRepo.area}",
            style = MaterialTheme.typography.h5,
            // modifier = Modifier.padding(20.dp, 20.dp),
        )
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .height(40.dp),
            shape = RoundedCornerShape(10),

        ) {
            Text(text = "Go Back ", color = MaterialTheme.colors.secondary)
        }
    }
}
