package com.yazantarifi.compose.library

import androidx.compose.ui.graphics.Color

data class MarkdownConfig(
    val textSizes: HashMap<String, Float>? = null,
    val isSingleComponent: Boolean = false,
    val backgroundColor: Color? = null,
    val paddingValue: Int? = 10,
    val isLinksClickable: Boolean = false,
    val colors: HashMap<String, Color>? = null,
    val isScrollEnabled: Boolean = true
)
