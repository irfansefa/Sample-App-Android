@file:OptIn(ExperimentalMaterial3Api::class)

package com.moonstarit.sampleapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moonstarit.sampleapp.R
import com.moonstarit.sampleapp.ui.theme.SampleAppTheme

@Composable
fun SampleTopAppBar(
    title: String,
    navigationIcon: ImageVector = Icons.Filled.Close,
    navigationDescription: String = stringResource(id = R.string.close),
    navigationOnClick: () -> Unit = {},
    colors: TopAppBarColors = SampleTopAppBarColors(),
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = navigationOnClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationDescription
                )
            }
        },
        colors = colors
    )
}

@Composable
private fun SampleTopAppBarColors(): TopAppBarColors =
    TopAppBarDefaults.smallTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.secondaryContainer,
        scrolledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        navigationIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
        actionIconContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
    )

@Preview
@Composable
private fun SampleTopAppBarPreview() {
    SampleAppTheme {
        SampleTopAppBar(
            title = "Sample Title",
        )
    }
}