package com.example.countriesapp.Navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object CountryCardList : Screen("countryCardUI_screen")
    object CountryDetails : Screen("countryDeatils_screen")
}
