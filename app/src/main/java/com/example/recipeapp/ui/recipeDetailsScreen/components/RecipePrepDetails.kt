package com.example.recipeapp.ui.recipeDetailsScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipeapp.R
import com.example.recipeapp.ui.theme.Dimens.SpaceExtraSmall

@Composable
fun RecipePrepDetailsComponent(
    modifier: Modifier = Modifier,
    totalServes: String,
    prepTimeAsString: String,
    prepTimeInHoursAndMinutes: Pair<Int, Int>,
    cookingTimeAsString: String,
    cookingTimeInHoursAndMinutes: Pair<Int, Int>
) {
    val (cookingHours, cookingMinutes) = cookingTimeInHoursAndMinutes
    val contentDescriptionForCooking = if (cookingHours != 0 && cookingMinutes != 0) {
        stringResource(
            R.string.recipe_cooking_time_hours_minutes_talkback,
            cookingHours,
            cookingMinutes
        )
    } else if(cookingHours != 0) {
        stringResource(
            R.string.recipe_cooking_time_hours_talkback,
            cookingHours
        )
    } else {
        stringResource(
            R.string.recipe_cooking_time_minutes_talkback,
            cookingMinutes
        )
    }

    val (prepHours, prepMinutes) = prepTimeInHoursAndMinutes
    val contentDescriptionForPrepTime = if (prepHours != 0 && prepMinutes != 0) {
        stringResource(
            R.string.recipe_prep_time_hours_minutes_talkback,
            prepHours,
            prepHours
        )
    } else if(prepHours != 0) {
        stringResource(
            R.string.recipe_prep_time_hours_talkback,
            prepHours
        )
    } else {
        stringResource(
            R.string.recipe_prep_time_minutes_talkback,
            prepMinutes
        )
    }

    val contentDescriptionForServes = stringResource(
        R.string.recipe_total_serves_talkback,
        totalServes
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clearAndSetSemantics {
                contentDescription = "$contentDescriptionForServes, $contentDescriptionForPrepTime, $contentDescriptionForCooking"
            },
    ) {
        HorizontalDivider(
            Modifier.height(1.dp)
        )
        Spacer(
            modifier = Modifier.height(SpaceExtraSmall)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .wrapContentWidth()
            ) {
                Text(
                    modifier = Modifier.clearAndSetSemantics {},
                    text = stringResource(R.string.recipe_details_screen_serves),
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal,
                    color = Color.Gray,
                )
                Spacer(
                    Modifier.height(4.dp)
                )
                Text(
                    text = totalServes,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clearAndSetSemantics {}
                )
            }
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .wrapContentWidth()
            ) {
                Text(
                    text = stringResource(R.string.recipe_details_screen_prep),
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal,
                    color = Color.Gray,
                    modifier = Modifier.clearAndSetSemantics {}
                )
                Spacer(
                    Modifier.height(4.dp)
                )
                Text(
                    text = prepTimeAsString,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clearAndSetSemantics {},
                )
            }
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .wrapContentWidth()
            ) {
                Text(
                    text = stringResource(R.string.recipe_details_screen_cooking),
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal,
                    color = Color.Gray,
                    modifier = Modifier.clearAndSetSemantics {}
                )
                Spacer(
                    Modifier.height(4.dp)
                )
                Text(
                    text = cookingTimeAsString,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .clearAndSetSemantics {}
                )
            }
        }
        Spacer(
            modifier = Modifier.height(SpaceExtraSmall)
        )
        HorizontalDivider(
            Modifier.height(1.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeDetailsPrepComponent() {
    RecipePrepDetailsComponent(
        totalServes = "8",
        prepTimeAsString = "8",
        prepTimeInHoursAndMinutes = Pair(3,3),
        cookingTimeInHoursAndMinutes = Pair(4,4),
        cookingTimeAsString = "20"
    )
}