package com.yazantarifi.compose.library

import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import org.commonmark.node.Node
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer

@Composable
fun MarkdownComposable(modifier: Modifier = Modifier, content: String) {
    val context = LocalContext.current
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        AndroidView(factory = {
            TextView(context).apply {
                text = convertMarkdownToHTML(content)?.let { it1 -> HtmlCompat.fromHtml(it1, HtmlCompat.FROM_HTML_MODE_COMPACT) }
            }
        }, modifier = modifier)
    }
}

fun convertMarkdownToHTML(markdown: String?): String? {
    val parser: Parser = Parser.builder().build()
    val document: Node = parser.parse(markdown)
    val htmlRenderer = HtmlRenderer.builder().build()
    return htmlRenderer.render(document)
}
