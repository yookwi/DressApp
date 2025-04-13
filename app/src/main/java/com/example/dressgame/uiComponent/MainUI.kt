package com.example.dressgame.uiComponent

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dressgame.model.ImageData
import com.example.dressgame.model.ImageListFactory

@Composable
fun MainUI(modifier: Modifier = Modifier) {
    val imageListSaver = listSaver<SnapshotStateList<ImageData>, Any>(
        save = { list ->
            list.flatMap {
                listOf(it.image, it.imageString, it.checked)
            }
        },
        restore = {
            val resList = mutableStateListOf<ImageData>()
            var idx = 0
            while (idx < it.size) {
                resList.add(
                    ImageData(
                        image = it[idx] as Int,
                        imageString = it[idx + 1] as String,
                        checked = it[idx + 2] as Boolean
                    )
                )
                idx += 3
            }
            resList
        }
    )
    val imageList =
        rememberSaveable(stateSaver = imageListSaver) { mutableStateOf(ImageListFactory.makeImageList()) }
    val orientation = LocalConfiguration.current.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column (modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text("202311256 권순호")
                ImageUI(imageList = imageList)
            }
            Column (modifier = Modifier.weight(1f)){
                ButtonList(imageList = imageList)
            }
        }
    }
    else {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text("202311256 권순호")
                ImageUI(imageList = imageList)
            }
            Column (modifier = Modifier.weight(1f)){
                ButtonList(imageList = imageList)
            }
        }

    }

}

@Preview
@Composable
private fun MainUIPreview() {
    MainUI()
}