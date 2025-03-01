package com.pocket.geminiapistarter

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun PromptView(promptViewModel: PromptViewModel) {
    val prompt by promptViewModel.promptText.collectAsState()
    Row {
        TextField(
            value = prompt,
            label = { Text(stringResource(R.string.label_prompt)) },
            onValueChange = { promptViewModel.setPromptText(it) },
            modifier = Modifier
                .weight(0.8f)
                .padding(end = 16.dp)
                .align(Alignment.CenterVertically)
        )

        Button(
            onClick = {
                /* val bitmap = BitmapFactory.decodeResource(
                     context.resources,
                     images[selectedImage.intValue]
                 )*/
                //  bakingViewModel.sendPrompt(bitmap, prompt)

            },
            enabled = prompt.isNotEmpty(),
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(text = stringResource(R.string.action_go))
        }
    }
}