package com.pocket.geminiapistarter

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun LoadImage(imageUri: Uri) {
    Image(
        painter = rememberAsyncImagePainter(imageUri),
        contentDescription = "Selected Image",
        modifier = Modifier.size(200.dp)
    )

    Spacer(modifier = Modifier.height(16.dp))
}

