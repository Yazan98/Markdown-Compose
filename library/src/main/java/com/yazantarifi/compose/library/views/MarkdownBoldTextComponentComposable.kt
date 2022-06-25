package com.yazantarifi.compose.library.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MarkdownBoldTextComponentComposable(text: String) {
    Text(text = text, fontWeight = FontWeight.Bold, modifier = Modifier.padding(5.dp))
}