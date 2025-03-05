package com.example.superheroes

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun SuperheroItem(
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .height(72.dp)
            .clip(MaterialTheme.shapes.medium),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Row (
            modifier = Modifier
        ) {
            Column {

            }

        }
    }
}

@Composable
fun HeroIcon(
    @DrawableRes heroIcon: Int,
    modifier: Modifier
){

}

@Composable
fun HeroInformation(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier
){

}

@Preview(showBackground = true)
@Composable
fun SuperheroItemPreview() {
    SuperheroesTheme {
        SuperheroItem()
    }
}