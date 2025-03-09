package com.example.recipeapp.ui.commonComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipeapp.R
import com.example.recipeapp.ui.theme.Dimens.SpaceSmall

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    errorMessage: String,
    retryButtonClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(SpaceSmall)
        ) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.error
            )
            if (retryButtonClick != null) {
                Button(
                    onClick = retryButtonClick
                ) {
                    Text(
                        text = stringResource(R.string.retry_button_text)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Error Screen With Retry")
@Composable
fun PreviewErrorScreeWithRetry() {
    ErrorScreen(
        errorMessage = stringResource(R.string.error_message_recipe_list_screen),
        retryButtonClick = {}
    )
}

@Preview(showBackground = true, name = "Error Screen Without Retry")
@Composable
fun PreviewErrorScreenWithoutRetry() {
    ErrorScreen(
        errorMessage = stringResource(R.string.error_message_recipe_list_screen),
    )
}