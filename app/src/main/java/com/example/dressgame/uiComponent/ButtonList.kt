package com.example.dressgame.uiComponent

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dressgame.model.ImageData

@Composable
fun ButtonList(modifier: Modifier = Modifier,imageList: MutableState<SnapshotStateList<ImageData>>) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        for (i in 0..4) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (j in (0..1)) {
                    val idx = i * 2 + j
                    DressButton(
                        modifier = Modifier.weight(1f),
                        str = imageList.value[idx].imageString,
                        checked = imageList.value[idx].checked
                    ) {
                        imageList.value[idx] = imageList.value[idx].copy(checked = it)
                    }
                }
            }
        }
    }
}