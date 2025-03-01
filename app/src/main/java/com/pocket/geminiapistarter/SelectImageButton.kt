package com.pocket.geminiapistarter

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SelectImageFromGalleryButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Select Image from Gallery")
    }
}