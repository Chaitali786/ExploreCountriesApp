package com.example.countriesapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countriesapp.model.CountryRepo
import com.example.countriesapp.network.ApiService
import kotlinx.coroutines.launch
import java.lang.Exception

class CountryListViewModel : ViewModel() {
    var countryListViewModelResponse: List<CountryRepo> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getCountryList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val countryList = apiService.getCountries()
                countryListViewModelResponse = countryList
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}
