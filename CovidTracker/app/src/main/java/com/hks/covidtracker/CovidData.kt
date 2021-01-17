package com.hks.covidtracker

data class CovidData(
    val dateChecked: String,
    val positiveIncrease: Int,
    val negativeIncrease: Int,
    val deathIncrease: Int,
    val state: String
)