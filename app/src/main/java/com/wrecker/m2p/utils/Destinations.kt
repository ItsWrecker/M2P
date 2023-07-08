package com.wrecker.m2p.utils

sealed class Destinations(val route: String) {
    object MainScreen: Destinations(route = "MainScreen")
    object DetailsScreen: Destinations(route = "DetailsScreen")
}