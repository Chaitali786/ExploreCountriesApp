package com.example.countriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.countriesapp.Navigation.Navigation
import com.example.countriesapp.ui.theme.CountriesAppTheme
import com.example.countriesapp.viewModel.CountryListViewModel

class MainActivity : ComponentActivity() {
    val countryListViewModel by viewModels<CountryListViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountriesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.secondary
                ) {
                    countryListViewModel.getCountryList()
                    Navigation(countryListViewModel.countryListViewModelResponse)
                }
            }
        }
    }
}
