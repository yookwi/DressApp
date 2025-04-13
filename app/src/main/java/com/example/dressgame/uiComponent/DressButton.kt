package com.example.dressgame.uiComponent

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DressButton(
    modifier: Modifier = Modifier,
    str: String,
    checked: Boolean,
    onChange: (Boolean) -> (Unit)
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked,
            onCheckedChange = { onChange(it) })
        Text(text = str)
    }
}

@Preview
@Composable
private fun DressButtonPreview() {
    var str: String by remember { mutableStateOf("abcd") }
    var checked = remember { mutableStateOf(false) }
    DressButton(str = str, checked = checked.value){
        checked.value = it
    }
}