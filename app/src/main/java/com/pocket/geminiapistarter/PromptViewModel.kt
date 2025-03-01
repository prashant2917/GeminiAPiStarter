package com.pocket.geminiapistarter

import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PromptViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<UiState> =
        MutableStateFlow(UiState.Initial)
    val uiState: StateFlow<UiState> =
        _uiState.asStateFlow()

    private val generativeModel = GenerativeModel(
        modelName = "gemini-2.0-flash",
        apiKey = BuildConfig.apiKey
    )

    private val _promptText: MutableStateFlow<String> = MutableStateFlow("")
    var promptText: StateFlow<String> = _promptText.asStateFlow()

    private val _bitmap: MutableStateFlow<Bitmap?> = MutableStateFlow(null)
    var bitmap: StateFlow<Bitmap?> = _bitmap.asStateFlow()

    private val _imageUri: MutableStateFlow<Uri?> = MutableStateFlow(null)
    var imageUri: StateFlow<Uri?> = _imageUri.asStateFlow()

    fun sendPrompt(
        bitmap: Bitmap?,
        prompt: String
    ) {
        _uiState.value = UiState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                /*val response = generativeModel.generateContent(
                    content {
                        image(bitmap)
                        text(prompt)
                    }
                )*/

                val response =
                    if (bitmap != null) generativeModel.generateContent(bitmap) else generativeModel.generateContent(
                        prompt
                    )

                response.text?.let { outputContent ->
                    _uiState.value = UiState.Success(outputContent)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "")
            }
        }
    }

    fun setPromptText(prompt: String) {
        _promptText.value = prompt

    }

    fun setBitmap(bitmap: Bitmap?) {
        _bitmap.value = bitmap
    }

    fun setImageUri(uri: Uri?) {
        _imageUri.value = uri

    }
}