package com.moonstarit.sampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.moonstarit.sampleapp.ui.civilizations.CivilizationsScreen
import com.moonstarit.sampleapp.ui.civilizations.CivilizationsViewModel
import com.moonstarit.sampleapp.ui.theme.SampleAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: CivilizationsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.loadCivilizations()

        setContent {
            SampleAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    viewModel.state.civilizationData?.let { civilizationData ->
                        CivilizationsScreen(civilizationData = civilizationData)
                    }
                    if (viewModel.state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    viewModel.state.error?.let { error ->
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
    }
}