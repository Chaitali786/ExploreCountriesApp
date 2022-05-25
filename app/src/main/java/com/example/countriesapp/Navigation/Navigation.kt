package com.example.countriesapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.countriesapp.model.CountryRepo
import com.example.countriesapp.view.CountryCardList
import com.example.countriesapp.view.CountryDetails
import com.example.countriesapp.view.Home

@Composable
fun Navigation(globacountryList: List<CountryRepo>) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            Home(navController = navController)
        }
        composable(route = Screen.CountryDetails.route) {
            val countryRepo = navController.previousBackStackEntry?.savedStateHandle?.get<CountryRepo>("countryRepo")
            countryRepo?.let {
                CountryDetails(navController = navController, countryRepo)
            }
        }
        composable(route = Screen.CountryCardList.route) {
            CountryCardList(navController = navController, globacountryList)
        }
    }
}
