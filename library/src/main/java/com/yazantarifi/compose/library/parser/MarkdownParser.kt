package com.yazantarifi.compose.library.parser

import com.yazantarifi.compose.library.MarkdownConfig
import com.yazantarifi.compose.library.MarkdownException
import com.yazantarifi.compose.library.MarkdownKeysManager
import com.yazantarifi.compose.library.components.*
import java.io.BufferedReader
import java.io.StringReader

open class MarkdownParser : MarkdownParserImplementation {

    private var currentConfig: MarkdownConfig? = null
    private var currentContent: String = ""
    private val contentComponents by lazy { ArrayList<MarkdownComponent>() }
    companion object {
        private const val EMPTY_COMPONENT = "Empty Component"
    }

    override fun setMarkdownConfig(config: MarkdownConfig): MarkdownParser {
        this.currentConfig = config
        return this
    }

    override fun setMarkdownContent(content: String): MarkdownParser {
        this.currentContent = content
        return this
    }

    override fun build(): ArrayList<MarkdownComponent> {
        parseMarkdownContent()
        return contentComponents
    }

    private fun parseMarkdownContent() {
        if (currentContent.isEmpty()) {
            throw MarkdownException()
        }

        val contentBufferReader = BufferedReader(StringReader(currentContent))
        var line: String = ""
        while (contentBufferReader.readLine().also { line = it ?: "" } != null) {
            var isComponentTriggered = false
            if (line.isEmpty()) {
                contentComponents.add(MarkdownSpaceComponent())
                continue
            }

            line = line.trim()
            if ((line.startsWith(MarkdownKeysManager.TEXT_H1) || line.startsWith(MarkdownKeysManager.TEXT_HASH)) && !line.contains("##")) {
                isComponentTriggered = true
                contentComponents.add(MarkdownStyledTextComponent(line.replace(MarkdownKeysManager.TEXT_H1, "").replace(MarkdownKeysManager.TEXT_HASH, ""), MarkdownKeysManager.TEXT_HASH))
            }

            if (line.startsWith(MarkdownKeysManager.TEXT_H2) || line.startsWith(MarkdownKeysManager.TEXT_HASH_2)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownStyledTextComponent(line.replace(MarkdownKeysManager.TEXT_H2, "").replace(MarkdownKeysManager.TEXT_HASH_2, ""), MarkdownKeysManager.TEXT_HASH_2))
            }

            if (line.startsWith(MarkdownKeysManager.TEXT_H3) || line.startsWith(MarkdownKeysManager.TEXT_HASH_3)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownStyledTextComponent(line.replace(MarkdownKeysManager.TEXT_H3, "").replace(MarkdownKeysManager.TEXT_HASH_3, ""), MarkdownKeysManager.TEXT_HASH_3))
            }

            if (line.startsWith(MarkdownKeysManager.TEXT_H4) || line.startsWith(MarkdownKeysManager.TEXT_HASH_4)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownStyledTextComponent(line.replace(MarkdownKeysManager.TEXT_H4, "").replace(MarkdownKeysManager.TEXT_HASH_4, ""), MarkdownKeysManager.TEXT_HASH_4))
            }

            if (line.startsWith(MarkdownKeysManager.TEXT_H5) || line.startsWith(MarkdownKeysManager.TEXT_HASH_5)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownStyledTextComponent(line.replace(MarkdownKeysManager.TEXT_H5, "").replace(MarkdownKeysManager.TEXT_HASH_5, ""), MarkdownKeysManager.TEXT_HASH_5))
            }

            if (line.startsWith(MarkdownKeysManager.TEXT_H6) || line.startsWith(MarkdownKeysManager.TEXT_HASH_6)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownStyledTextComponent(line.replace(MarkdownKeysManager.TEXT_H6, "").replace(MarkdownKeysManager.TEXT_HASH_6, ""), MarkdownKeysManager.TEXT_HASH_6))
            }

            if (line.startsWith(MarkdownKeysManager.IMAGE_START) && line.contains(MarkdownKeysManager.IMAGE_END)) {
                isComponentTriggered = true
                val imageUrl = line.split(MarkdownKeysManager.IMAGE_END).get(1).replace(")", "")
                if (isImagePath(imageUrl)) {
                    contentComponents.add(MarkdownImageComponent(imageUrl))
                } else {
                    contentComponents.add(MarkdownShieldComponent(imageUrl))
                }
            }

            if (line.startsWith(MarkdownKeysManager.IMAGE_WITHOUT_TAG_KEY)) {
                isComponentTriggered = true
                val imageUrl = line.split(MarkdownKeysManager.IMAGE_END).get(1).replace(")", "")
                if (isImagePath(imageUrl)) {
                    contentComponents.add(MarkdownImageComponent(imageUrl))
                } else {
                    contentComponents.add(MarkdownShieldComponent(imageUrl))
                }
            }

            if (line.startsWith(MarkdownKeysManager.NOTE)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownNoteComponent(line.replace(MarkdownKeysManager.NOTE, "")))
            }

            if (line.startsWith(MarkdownKeysManager.CHECK_BOX_EMPTY)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownCheckBoxComponent(false, line.replace(MarkdownKeysManager.CHECK_BOX_EMPTY, "")))
            }

            if (line.startsWith(MarkdownKeysManager.CHECK_BOX_EMPTY_2)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownCheckBoxComponent(false, line.replace(MarkdownKeysManager.CHECK_BOX_EMPTY_2, "")))
            }

            if (line.startsWith(MarkdownKeysManager.CHECK_BOX_FILL)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownCheckBoxComponent(true, line.replace(MarkdownKeysManager.CHECK_BOX_FILL, "")))
            }

            if (line.startsWith(MarkdownKeysManager.CHECK_BOX_FILL_2)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownCheckBoxComponent(true, line.replace(MarkdownKeysManager.CHECK_BOX_FILL_2, "")))
            }

            if (line.startsWith(MarkdownKeysManager.LINK_START) && line.contains(MarkdownKeysManager.LINK_CONTAINS)) {
                val fragments = line.split(MarkdownKeysManager.LINK_CONTAINS)
                val text = fragments.get(0).replace("[", "")
                val link = fragments.get(1).replace(")", "")
                contentComponents.add(MarkdownLinkComponent(text, link))
                isComponentTriggered = true
            }

            if (line.contains(MarkdownKeysManager.BOLD)) {
                isComponentTriggered = true
                contentComponents.add(MarkdownBoldTextComponent(line.replace(MarkdownKeysManager.BOLD, "")))
            }

            if (line.contains(MarkdownKeysManager.ITALIC) && !isComponentTriggered) {
                isComponentTriggered = true
                contentComponents.add(MarkdownItalicTextComponent(line.replace(MarkdownKeysManager.BOLD, "")))
            }

            if (!isComponentTriggered) {
                contentComponents.add(MarkdownTextComponent(line))
            }
        }
    }

    private fun isImagePath(imageUrl: String): Boolean {
        return imageUrl.contains(".png") || imageUrl.contains(".jpg") || imageUrl.contains(".jpeg") || imageUrl.contains(".webp") || imageUrl.contains(".bmp")
    }

}