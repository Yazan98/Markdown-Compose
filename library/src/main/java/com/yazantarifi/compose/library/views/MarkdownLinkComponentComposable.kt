package com.yazantarifi.compose.library.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MarkdownLinkComponentComposable(text: String, link: String, onLinkClickListener: (String) -> Unit) {
    Text(text = text, modifier = Modifier.padding(5.dp).clickable { onLinkClickListener(link) })
}