@file:OptIn(ExperimentalMaterial3Api::class)

package com.moonstarit.sampleapp.ui.civilizations

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moonstarit.sampleapp.domain.model.CivilizationData
import org.koin.androidx.compose.getViewModel

@Composable
fun CivilizationsScreen(
    onClickCivilization: () -> Unit = {},
    viewModel: CivilizationsViewModel = getViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        uiState.civilizationData?.let { civilizationData ->
            CivilizationsListScreen(
                civilizationData = civilizationData,
                onClickCivilization = onClickCivilization,
            )
        }
        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        uiState.error?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CivilizationsListScreen(
    onClickCivilization: () -> Unit = {},
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
                        caption = item.armyType,
                        onClickCivilization = onClickCivilization,
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
    caption: String? = null,
    onClickCivilization: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable { onClickCivilization() },
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