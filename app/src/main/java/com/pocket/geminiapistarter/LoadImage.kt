package com.pocket.geminiapistarter

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.pocket.geminiapistarter.utils.Utils.uriToBitmap

@Composable
fun LoadImage(context: Context, imageUri: Uri, promptViewModel: PromptViewModel) {
    Image(
        painter = rememberAsyncImagePainter(imageUri),
        contentDescription = "Selected Image",
        modifier = Modifier.size(200.dp)
    )

    Spacer(modifier = Modifier.height(16.dp))

    Row {
        val modifier = Modifier
            .weight(0.5f)
        PromptAppButton(
            onClick = { sendPrompt(context, imageUri, promptViewModel) },
            buttonText = "Describe Image",
            modifier
        )
        PromptAppButton(
            onClick = { removeImage(promptViewModel) },
            buttonText = "Remove Image",
            modifier
        )

    }

}

fun sendPrompt(context: Context, imageUri: Uri, promptViewModel: PromptViewModel) {
    val bitmap = uriToBitmap(context, imageUri)
    promptViewModel.setBitmap(bitmap)
    promptViewModel.sendPrompt(bitmap, "")
}

fun removeImage(promptViewModel: PromptViewModel) {
    promptViewModel.setBitmap(null)
    promptViewModel.setImageUri(null)
}

