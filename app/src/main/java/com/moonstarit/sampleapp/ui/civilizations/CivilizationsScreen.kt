@file:OptIn(ExperimentalMaterial3Api::class)

package com.moonstarit.sampleapp.ui.civilizations

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.ui.components.ItemCard
import org.koin.androidx.compose.getViewModel

@Composable
fun CivilizationsScreen(
    onClickCivilization: (id: Long) -> Unit = {},
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
private fun CivilizationsListScreen(
    onClickCivilization: (id: Long) -> Unit = {},
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
                        onCardClicked = { onClickCivilization(item.id) },
                    )
                }
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview
@Composable
private fun CivilizationsScreenPreview() {

    val data = CivilizationData(
        id = 0,
        name = "Turks",
        expansion = "Age Of Kings",
        armyType = "Infantry and Monk",
        uniqueUnits = listOf(),
        uniqueTechs = listOf(),
        teamBonus = "",
        civilizationBonus = listOf()
    )

    MaterialTheme {
        CivilizationsListScreen(
            civilizationData = listOf(data)
        )
    }
}
