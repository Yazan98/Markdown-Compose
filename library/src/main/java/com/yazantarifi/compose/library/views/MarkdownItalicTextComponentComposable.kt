package com.yazantarifi.compose.library.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun MarkdownItalicTextComponentComposable(text: String) {
    Text(text = text, fontStyle = FontStyle.Italic, modifier = Modifier.padding(5.dp))
}