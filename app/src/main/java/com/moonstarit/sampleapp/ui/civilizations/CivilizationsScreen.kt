@file:OptIn(ExperimentalMaterial3Api::class)

package com.moonstarit.sampleapp.ui.civilizations

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moonstarit.sampleapp.domain.model.CivilizationData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CivilizationsScreen(
    civilizationData: List<CivilizationData>
) {
    Scaffold() { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(civilizationData) { item ->
                    ItemCard(
                        title = item.name,
                        subtitle = item.expansion,
                        caption = item.armyType
                    )
                }
            }
        }
    }
}

@Composable
fun ItemCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    caption: String? = null
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable { },
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

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
@Composable
fun CivilizationsScreenPreview() {
    MaterialTheme {
        ItemCard(title = "Turks", subtitle = "Age Of Kings", caption = "Infantry and Monk")
    }
}