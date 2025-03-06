package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.Hero
import com.example.superheroes.data.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun SuperheroItem(
    superhero: Hero,
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row (
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
                .fillMaxWidth()
                .sizeIn(minHeight = 72.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroInformation(heroName = superhero.nameRes, heroDescription = superhero.descriptionRes, Modifier.weight(1f))
            Spacer(Modifier.width(16.dp))
            HeroIcon(heroIcon = superhero.imageRes, contentDesc = superhero.nameRes)
        }
    }
}

@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    @StringRes contentDesc: Int,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .size(dimensionResource(R.dimen.image_size)),
        painter = painterResource(heroIcon),
        contentDescription = stringResource(contentDesc),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun HeroApp(){
    Scaffold (
        topBar = {
            HeroTopAppBar()
        }
    ){ it ->
        LazyColumn (contentPadding = it) {
            items(HeroesRepository.heroes){
                SuperheroItem(
                    superhero = it,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroItemPreview() {
    SuperheroesTheme {
        HeroApp()
    }
}