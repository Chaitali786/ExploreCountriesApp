package com.example.countriesapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class CountryRepo(
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val capitalInfo: @RawValue CapitalInfo,
    val car: @RawValue Car,
    val cca2: String,
    val cca3: String,
    val ccn3: String,
    val cioc: String,
    val coatOfArms: @RawValue CoatOfArms,
    val continents: List<String>,
    val currencies: @RawValue Currencies,
    val demonyms: @RawValue Demonyms,
    val fifa: String,
    val flag: String,
    val flags: @RawValue Flags,
    val gini: @RawValue Gini,
    val idd: @RawValue Idd,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: @RawValue Languages,
    val latlng: List<Double>,
    val maps: @RawValue Maps,
    val name: @RawValue Name,
    val population: Int,
    val postalCode: @RawValue PostalCode,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String>,
    val translations: @RawValue Translations,
    val unMember: Boolean
) : Parcelable
