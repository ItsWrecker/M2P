package com.wrecker.m2p.compose

import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.wrecker.m2p.utils.Destinations
import com.wrecker.presentation.action.PokemonAction
import com.wrecker.presentation.viewModel.PokemonViewModel
import com.wrecker.presentation.viewModel.state.SortType
@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun MainScreen(navController: NavController, viewModel: PokemonViewModel) {
    val state by viewModel.state.collectAsState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp).padding(bottom = 48.dp)
    ) {

        val (search, pokemon, sort) = createRefs()

        val searchInput = remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(search) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            value = searchInput.value,
            onValueChange = {
                searchInput.value = it
                if (searchInput.value.isBlank()) {
                    viewModel.onEvent(PokemonAction.GetPokemon(20))
                }
            },
            keyboardActions = KeyboardActions(onDone = {
                viewModel.onEvent(PokemonAction.Search(searchInput.value))
            }),
            singleLine = true,
            label = { Icon(Icons.Filled.Search, contentDescription = "") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii)
        )



        Row(modifier = Modifier.constrainAs(sort) {
            top.linkTo(search.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            SortType.values().forEach { sortType ->
                Row(modifier = Modifier.clickable() {
                    viewModel.onEvent(PokemonAction.OrderBy(sortType))
                }, verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = state.pokemonOrder == sortType,
                        onClick = { viewModel.onEvent(PokemonAction.OrderBy(sortType)) }
                    )
                    Text(text = sortType.name)
                }
            }
        }
        LazyColumn(
            modifier = Modifier
                .constrainAs(pokemon) {
                    top.linkTo(sort.bottom)
                    start.linkTo(search.start)
                    end.linkTo(search.end)
                }
                .padding(vertical = 32.dp),
            verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.Start
        ) {
            itemsIndexed(state.pokemon) { index, value ->
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .selectable(true, onClick = {
                            navController.navigate(Destinations.DetailsScreen.route + "/${value.id}")
                        }),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, color = Color.LightGray)
                ) {
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        val (image, name, types, level, hp) = createRefs()

                        GlideImage(
                            modifier = Modifier
                                .constrainAs(image) {
                                    top.linkTo(parent.top)
                                    start.linkTo(parent.start)
                                }
                                .size(100.dp),
                            model = value.images.small,
                            contentDescription = "pokemonThumbnail",
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Name: ${value.name}",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .constrainAs(name) {
                                    top.linkTo(image.top)
                                    start.linkTo(image.end)
                                }
                                .padding(4.dp)
                        )

                        Text(
                            text = "Types: ${value.types}",
                            modifier = Modifier.constrainAs(types) {
                                top.linkTo(name.bottom)
                                start.linkTo(name.start)
                            }
                        )
                        Text(
                            text = "Level: ${value.level}",
                            modifier = Modifier.constrainAs(level) {
                                top.linkTo(types.bottom)
                                start.linkTo(name.start)
                            }
                        )

                        Text(
                            text = "HP: ${value.hp}",
                            modifier = Modifier.constrainAs(hp) {
                                top.linkTo(level.bottom)
                                start.linkTo(name.start)
                            }
                        )
                    }
                }
            }
        }

    }
}