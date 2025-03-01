package com.pocket.geminiapistarter

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PromptAppButton(onClick: () -> Unit, buttonText: String, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(buttonText)
    }
}