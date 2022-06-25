package com.yazantarifi.compose.library.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalUnitApi::class)
@Composable
fun MarkdownTextComponentComposable(text: String, color: Color) {
    Text(text = text, fontSize = TextUnit(13f, TextUnitType.Sp), color = color, modifier = Modifier.padding(5.dp))
}