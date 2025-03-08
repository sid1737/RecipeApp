package com.example.recipeapp.ui.recipeListScreen.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipeapp.R
import com.example.recipeapp.ui.theme.PaddingMedium

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    errorMessage: String,
    errorButtonText: String,
    retryButtonClick: () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(PaddingMedium)
        ) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Red
            )
            Button(
                onClick = retryButtonClick
            ) {
                Text(
                    text = errorButtonText
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewErrorScreen() {
    ErrorScreen(
        errorMessage = stringResource(R.string.error_message),
        errorButtonText = stringResource(R.string.retry_button_text),
        retryButtonClick = {}
    )
}