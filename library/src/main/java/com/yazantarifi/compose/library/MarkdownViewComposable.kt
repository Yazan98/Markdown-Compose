package com.yazantarifi.compose.library

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.yazantarifi.compose.library.components.*
import com.yazantarifi.compose.library.parser.MarkdownParser
import com.yazantarifi.compose.library.views.*

@Composable
fun MarkdownViewComposable(
    modifier: Modifier,
    content: String,
    config: MarkdownConfig,
    onLinkClickListener: (String) -> Unit
) {
    val parser = MarkdownParser()
        .setMarkdownConfig(config)
        .setMarkdownContent(content)
        .build()

    Box(modifier = modifier) {
        LazyColumn {
            items(parser) { item ->
                when (item) {
                    is MarkdownLinkComponent -> MarkdownLinkComponentComposable(item.text, item.link, onLinkClickListener)
                    is MarkdownCheckBoxComponent -> MarkdownCheckBoxComponentComposable(item.text, item.isChecked)
                    is MarkdownShieldComponent -> MarkdownShieldComponentComposable(item.url)
                    is MarkdownTextComponent -> MarkdownTextComponentComposable(item.text, Color.Black)
                    is MarkdownSpaceComponent -> MarkDownSpaceComponentComposable()
                    is MarkdownImageComponent -> MarkdownImageComponentComposable(item.image)
                    is MarkdownStyledTextComponent -> MarkdownStyledTextComponentComposable(item.text, item.layer)
                }
            }
        }
    }
}
