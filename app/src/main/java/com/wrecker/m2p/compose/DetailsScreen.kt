package com.wrecker.m2p.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.wrecker.presentation.viewModel.PokemonDetailsViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsScreen(id: String, viewModel: PokemonDetailsViewModel) {
    viewModel.details(id)
    val state by viewModel.state.collectAsState()

    state.data?.let { pokemon ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            val (image, name, types, subTypes, level, hp, attacks, weakness, ability, resistance) = createRefs()
            OutlinedCard(modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .padding(16.dp), border = BorderStroke(1.dp, Color.Gray)) {
                GlideImage(
                    model = pokemon.images.large,
                    contentDescription = "image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.FillBounds
                )
            }

            OutlinedCard(
                modifier = Modifier
                    .padding(16.dp)
                    .constrainAs(name) {
                        top.linkTo(image.bottom)
                        start.linkTo(image.start)
                        end.linkTo(image.end)
                    }
                    .safeContentPadding(),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Text(
                    text = pokemon.name.toUpperCase(Locale.current),
                    fontSize = 24.sp,
                    color = Color.Cyan,
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp),
                    textAlign = TextAlign.Center
                )
            }

            OutlinedCard(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .constrainAs(types) {
                        top.linkTo(name.bottom)
                        start.linkTo(name.start)
                        end.linkTo(name.end)
                    }
                    .safeContentPadding(),
                border = BorderStroke(1.dp, Color.LightGray)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(text = "Types: ${pokemon.types}")
                    Divider(thickness = 1.dp, modifier = Modifier.padding(16.dp))
                    Text(text = "Sub Types: ${pokemon.subtypes}")
                    Divider(thickness = 1.dp, modifier = Modifier.padding(16.dp))
                    Text(text = "Level: ${pokemon.level}")
                    Divider(thickness = 1.dp, modifier = Modifier.padding(16.dp))
                    Text(text = "HP: ${pokemon.hp}")
                    Divider(thickness = 1.dp, modifier = Modifier.padding(16.dp))
                    Text(text = "Attacks: ${pokemon.attacks}")
                    Divider(thickness = 1.dp, modifier = Modifier.padding(16.dp))
                    Text(text = "Weakness: ${pokemon.weaknesses}")
                    Divider(thickness = 1.dp, modifier = Modifier.padding(16.dp))
                    Text(text = "Resistance: ${pokemon.resistances}")
                }
            }
        }
    }

}