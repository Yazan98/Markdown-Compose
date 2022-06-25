package com.yazantarifi.compose.library.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun MarkdownImageComponentComposable(imageUrl: String) {
    AsyncImage(model = imageUrl, contentDescription = "Image Url Here")
}
