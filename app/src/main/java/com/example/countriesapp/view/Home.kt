package com.example.countriesapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.countriesapp.Navigation.Screen
import com.example.countriesapp.R
import com.example.countriesapp.ui.theme.CountriesAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewHome() {
    CountriesAppTheme() {
        Home(navController = rememberNavController())
    }
}
@Composable
fun Home(navController: NavHostController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp, 50.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = R.drawable.earth),
            contentDescription = null,
            modifier = Modifier
                .size(230.dp)
                .clip(CircleShape)
                .align(alignment = Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Explore Countries",
            fontSize = 9.sp
        )
    }
    Spacer(modifier = Modifier.height(360.dp))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(360.dp))
        Text(
            text = "Learn about the countries of the world - capitals, populations, languages, GDPs, religions, flags & more.Find countries using the interactive country list.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp, horizontal = 10.dp),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primaryVariant,
            fontSize = 24.sp,
        )

        Button(
            onClick = {
                navController.navigate(Screen.CountryCardList.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .height(40.dp),
            shape = RoundedCornerShape(10),
        ) {
            Text(text = "Let's Go!", color = MaterialTheme.colors.secondary)
        }
    }
}
