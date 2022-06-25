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
    onLinkClickListener: (String, Int) -> Unit
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
                    RenderComponent(item, config, onLinkClickListener)
                }
            }
        } else {
            Column {
                parser.forEach {
                    RenderComponent(it, config, onLinkClickListener)
                }
            }
        }
    }
}

@Composable
private fun RenderComponent(item: MarkdownComponent, config: MarkdownConfig, onLinkClickListener: (String, Int) -> Unit) {
    when (item) {
        is MarkdownCodeComponent -> MarkdownCodeComponentComposable(text = item.codeBlock, config.colors?.get(MarkdownConfig.CODE_BACKGROUND_COLOR) ?: Color.Gray, config.colors?.get(MarkdownConfig.CODE_BLOCK_TEXT_COLOR) ?: Color.White)
        is MarkdownItalicTextComponent -> MarkdownItalicTextComponentComposable(text = item.text, config.colors?.get(MarkdownConfig.TEXT_COLOR) ?: Color.Black)
        is MarkdownBoldTextComponent -> MarkdownBoldTextComponentComposable(text = item.text, config.colors?.get(MarkdownConfig.TEXT_COLOR) ?: Color.Black)
        is MarkdownLinkComponent -> MarkdownLinkComponentComposable(item.text, item.link, config.isLinksClickable, onLinkClickListener)
        is MarkdownCheckBoxComponent -> MarkdownCheckBoxComponentComposable(item.text, item.isChecked)
        is MarkdownShieldComponent -> MarkdownShieldComponentComposable(item.url)
        is MarkdownTextComponent -> MarkdownTextComponentComposable(item.text, config.colors?.get(MarkdownConfig.TEXT_COLOR) ?: Color.Black)
        is MarkdownSpaceComponent -> MarkDownSpaceComponentComposable()
        is MarkdownImageComponent -> MarkdownImageComponentComposable(item.image, config.isImagesClickable, onLinkClickListener)
        is MarkdownStyledTextComponent -> MarkdownStyledTextComponentComposable(item.text, item.layer, color = config.colors?.get(MarkdownConfig.HASH_TEXT_COLOR) ?: Color.Black)
    }
}
