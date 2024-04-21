package com.example.movieapp.screens.home.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Movies") },
                colors = TopAppBarDefaults.topAppBarColors (
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
            )
        }
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
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
    "The Fast and Furious"
)) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                }
            }
        }
    }
}
