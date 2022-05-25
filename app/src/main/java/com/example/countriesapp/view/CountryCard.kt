package com.example.countriesapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.countriesapp.Navigation.Screen
import com.example.countriesapp.model.CountryRepo

@Preview(showBackground = true)
@Composable
fun CountryCard(countryRepo: CountryRepo, navController: NavHostController) {
    val paddingModifier = Modifier.padding(5.dp)
    Card(
        elevation = 10.dp,
        modifier = paddingModifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Surface(
            modifier = Modifier.clickable {
                navController.currentBackStackEntry?.savedStateHandle?.set("countryRepo", countryRepo)
                navController.navigate(Screen.CountryDetails.route)
            }
        ) {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .weight(0.2f)
                ) {
                    Image(
                        painter = rememberImagePainter(data = countryRepo.flags.png),
                        contentDescription = countryRepo.status,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.2f)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .weight(0.2f)
                ) {
                    Text(
                        text = countryRepo.name.common, style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Text(
                        text = countryRepo.capital.toString(), style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                    Text(
                        text = countryRepo.region, style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}
