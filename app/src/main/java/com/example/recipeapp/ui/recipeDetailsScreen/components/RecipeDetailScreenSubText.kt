import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecipeDetailScreenSubText(
    modifier: Modifier = Modifier,
    recipeSubText: String
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .semantics {
                contentDescription = recipeSubText
            },
        text = recipeSubText,
        style = MaterialTheme.typography.bodyLarge,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Normal
    )
}

@Preview
@Composable
fun PreviewRecipeDetailScreenSubText() {
    RecipeDetailScreenSubText(
        recipeSubText = "Recipe Subtext"
    )
}