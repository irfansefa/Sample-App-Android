package com.moonstarit.sampleapp.ui.civilizations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.ui.components.ListHeader
import com.moonstarit.sampleapp.ui.components.ListItem
import com.moonstarit.sampleapp.ui.components.SampleTopAppBar
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CivilizationDetailScreen(
    civilizationId: Long,
    upPress: () -> Unit,
    viewModel: CivilizationDetailViewModel = getViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(key1 = civilizationId) {
        viewModel.loadDetails(civilizationId)
    }
    Scaffold(
        modifier = Modifier,
        topBar = {
            SampleTopAppBar(
                title = uiState.civilizationData?.name ?: "Detail",
                navigationOnClick = upPress
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            uiState.civilizationData?.let { civilizationData ->
                CivilizationDetailContent(civilizationData = civilizationData)
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
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CivilizationDetailContent(
    civilizationData: CivilizationData
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        stickyHeader { ListHeader(text = "Army Type") }
        item {
            ListItem(text = civilizationData.armyType)
        }
        stickyHeader { ListHeader(text = "Expansion") }
        item {
            ListItem(text = civilizationData.expansion)
        }
        stickyHeader { ListHeader(text = "Team Bonus") }
        item {
            ListItem(text = civilizationData.teamBonus)
        }
        stickyHeader { ListHeader(text = "Civilization Bonus") }
        items(civilizationData.civilizationBonus) { civilizationBonus ->
            ListItem(text = civilizationBonus)
        }
        stickyHeader { ListHeader(text = "Unique Techs") }
        items(civilizationData.uniqueTechs) { uniqueTechs ->
            ListItem(text = uniqueTechs)
        }
        stickyHeader { ListHeader(text = "Unique Units") }
        items(civilizationData.uniqueUnits) { uniqueUnits ->
            ListItem(text = uniqueUnits)
        }
    }
}