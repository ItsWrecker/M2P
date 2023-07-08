package com.wrecker.m2p

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.wrecker.m2p.compose.DetailsScreen
import com.wrecker.m2p.compose.MainScreen
import com.wrecker.m2p.ui.theme.M2PTheme
import com.wrecker.m2p.utils.Destinations
import com.wrecker.presentation.viewModel.PokemonDetailsViewModel
import com.wrecker.presentation.viewModel.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val pokemonViewModel by viewModels<PokemonViewModel>()
    private val detailsViewModel by viewModels<PokemonDetailsViewModel>()
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            M2PTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { TopAppBar(title = { Text(text = "Pokemon") }) }
                    ) {

                        val navController = rememberNavController()

                        NavHost(
                            modifier = Modifier.padding(it),
                            navController = navController,
                            startDestination = Destinations.MainScreen.route
                        ) {
                            composable(route = Destinations.MainScreen.route) {
                                MainScreen(navController = navController, pokemonViewModel)
                            }
                            composable(route = Destinations.DetailsScreen.route + "/{id}",
                                arguments = listOf(
                                    navArgument("id") {
                                        type = NavType.StringType
                                    }
                                )) { backstackEntry ->
                                val id = backstackEntry.arguments?.getString("id")
                                if (id != null) {
                                    DetailsScreen(id, detailsViewModel)
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}