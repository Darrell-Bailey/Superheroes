package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
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
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .clip(MaterialTheme.shapes.medium),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row (
            modifier = Modifier
                .height(104.dp)
                .padding(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            HeroInformation(heroName = superhero.nameRes, heroDescription = superhero.descriptionRes)
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
        painter = painterResource(heroIcon),
        contentDescription = stringResource(contentDesc),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
    )
}

@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier
            .padding(end = dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroItemPreview() {
    SuperheroesTheme {
        SuperheroItem(HeroesRepository.heroes[0])
    }
}