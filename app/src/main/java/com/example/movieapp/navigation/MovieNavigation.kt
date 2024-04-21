package com.example.movieapp.navigation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.movieapp.MovieRow
import com.example.movieapp.screens.home.HomeScreen


@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name) {
        composable (MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
    }
}

@Composable
fun MainContent(movieList: List<String> = listOf(
    "No Country for Old Men",
    "Pulp Fiction",
    "Harry Potter",
    "Lord of the Rings",
    "Pursuit of Happiness",
    "300",
    "Ace Ventura",
    "American Sniper",
    "Bad Boys 1",
    "Bad Boys 2",
    "The Fast and Furious")) {

    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) {
                        movie ->
                    Log.d("TAG", "MainContent: $movie")
                }

            }
        }

    }


}