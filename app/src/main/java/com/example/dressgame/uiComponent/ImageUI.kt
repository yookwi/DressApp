package com.example.dressgame.uiComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.dressgame.R
import com.example.dressgame.model.ImageData

@Composable
fun ImageUI(modifier: Modifier = Modifier, imageList: MutableState<SnapshotStateList<ImageData>>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            painter = painterResource(id = R.drawable.body),
            contentDescription = "body"
        )
        imageList.value.forEachIndexed { index, imageData ->
            if (imageData.checked == true) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    painter = painterResource(id = imageData.image),
                    contentDescription = imageData.imageString
                )
            }
        }
    }
}