package com.yazantarifi.compose.library.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp

@Composable
fun MarkdownCheckBoxComponentComposable(text: String, color: Color, isChecked: Boolean) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        val checkedState = remember { mutableStateOf(isChecked) }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = isChecked },
            colors = CheckboxDefaults.colors(color)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = text)
    }
}
