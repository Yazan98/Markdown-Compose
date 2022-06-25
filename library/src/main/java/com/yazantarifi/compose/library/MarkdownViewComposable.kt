package com.yazantarifi.compose.library

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
        val isScrollEnabled = config.isScrollEnabled
        if (isScrollEnabled) {
            LazyColumn {
                items(parser) { item ->
                    RenderComponent(item, onLinkClickListener)
                }
            }
        } else {
            Column {
                parser.forEach {
                    RenderComponent(it, onLinkClickListener)
                }
            }
        }
    }
}

@Composable
private fun RenderComponent(item: MarkdownComponent, onLinkClickListener: (String) -> Unit) {
    when (item) {
        is MarkdownItalicTextComponent -> MarkdownItalicTextComponentComposable(text = item.text)
        is MarkdownBoldTextComponent -> MarkdownBoldTextComponentComposable(text = item.text)
        is MarkdownLinkComponent -> MarkdownLinkComponentComposable(item.text, item.link, onLinkClickListener)
        is MarkdownCheckBoxComponent -> MarkdownCheckBoxComponentComposable(item.text, item.isChecked)
        is MarkdownShieldComponent -> MarkdownShieldComponentComposable(item.url)
        is MarkdownTextComponent -> MarkdownTextComponentComposable(item.text, Color.Black)
        is MarkdownSpaceComponent -> MarkDownSpaceComponentComposable()
        is MarkdownImageComponent -> MarkdownImageComponentComposable(item.image)
        is MarkdownStyledTextComponent -> MarkdownStyledTextComponentComposable(item.text, item.layer)
    }
}
