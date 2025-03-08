package com.example.recipeapp.ui.recipeDetailsScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recipeapp.R
import com.example.recipeapp.ui.theme.SpaceSmall

@Composable
fun RecipePrepDetailsComponent(
    modifier: Modifier = Modifier,
    totalServes: String,
    prepTimeAsString: String,
    prepTimeAsMinutes: Int,
    cookingTimeAsString: String,
    cookingTimeAsMinutes: Int
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .semantics {
                contentDescription = "This can be served between $totalServes and the required prep time is $prepTimeAsMinutes and cooking time is $cookingTimeAsMinutes"
            }
    ) {
        HorizontalDivider(
            Modifier.height(1.dp)
        )
        Spacer(
            modifier = Modifier.height(SpaceSmall)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth()
                ) {
                    Text(
                        modifier = Modifier.clearAndSetSemantics {},
                        text = stringResource(R.string.recipe_details_screen_serves),
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color.Gray,
                    )
                    Spacer(
                        Modifier.height(3.dp)
                    )
                    Text(
                        text = totalServes,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .clearAndSetSemantics {}
                    )
                }
            }
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .wrapContentHeight()
                    .height(50.dp)
            )
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth()
                ) {
                    Text(
                        text = stringResource(R.string.recipe_details_screen_prep),
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color.Gray,
                        modifier = Modifier.clearAndSetSemantics {}
                    )
                    Spacer(
                        Modifier.height(3.dp)
                    )
                    Text(
                        text = prepTimeAsString,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .clearAndSetSemantics {},
                    )
                }
            }
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .wrapContentHeight()
                    .height(50.dp)
            )
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .wrapContentWidth()
                ) {
                    Text(
                        text = stringResource(R.string.recipe_details_screen_cooking),
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal,
                        color = Color.Gray,
                        modifier = Modifier.clearAndSetSemantics {}
                    )
                    Spacer(
                        Modifier.height(3.dp)
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
        }
        Spacer(
            modifier = Modifier.height(SpaceSmall)
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
        prepTimeAsMinutes = 8,
        cookingTimeAsMinutes = 20,
        cookingTimeAsString = "20"
    )
}
