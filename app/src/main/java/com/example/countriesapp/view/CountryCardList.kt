package com.example.countriesapp.view
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.countriesapp.model.CountryRepo
import com.example.countriesapp.ui.theme.CountriesAppTheme

@Preview(showBackground = true)
@Composable
fun PreviewCountryCardScreen(globacountryList: List<CountryRepo>) {
    CountriesAppTheme() {
        CountryCardList(
            navController = rememberNavController(),
            globacountryList
        )
    }
}
@Composable
fun CountryCardList(navController: NavHostController, globacountryList: List<CountryRepo>) {
    CountryList(navController, globacountryList)
}
@Preview(showBackground = true)
@Composable
fun CountryList(navController: NavHostController, countryList: List<CountryRepo>) {
    val context = LocalContext.current
    val enabled: Boolean = true
    LazyColumn(
        modifier = Modifier.scrollEnabled(
            enabled = enabled, // provide a mutable state boolean here
        )
    ) {
        itemsIndexed(items = countryList) { index, item -> CountryCard(countryRepo = item, navController) }
    }
}
fun Modifier.scrollEnabled(
    enabled: Boolean,
) = nestedScroll(
    connection = object : NestedScrollConnection {
        override fun onPreScroll(
            available: Offset,
            source: NestedScrollSource
        ): Offset = if (enabled) Offset.Zero else available
    }
)
