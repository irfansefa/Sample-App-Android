package com.moonstarit.sampleapp.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    caption: String? = null,
    onCardClicked: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable { onCardClicked() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium
            )
            caption?.let {
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = caption,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview
@Composable
private fun ItemCardPreview() {
    MaterialTheme {
        ItemCard(title = "Turks", subtitle = "Age Of Kings", caption = "Infantry and Monk")
    }
}