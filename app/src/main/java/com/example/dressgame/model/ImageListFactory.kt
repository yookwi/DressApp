package com.example.dressgame.model

import androidx.compose.runtime.mutableStateListOf
import com.example.dressgame.R

object ImageListFactory {
    fun makeImageList() = mutableStateListOf(
        ImageData(R.drawable.arms, "arms"),
        ImageData(R.drawable.ears, "ears"),
        ImageData(R.drawable.eyebrows, "eyebrows"),
        ImageData(R.drawable.eyes, "eyes"),
        ImageData(R.drawable.glasses, "glasses"),
        ImageData(R.drawable.hat, "hat"),
        ImageData(R.drawable.mouth, "mouth"),
        ImageData(R.drawable.mustache, "mustache"),
        ImageData(R.drawable.nose, "nose"),
        ImageData(R.drawable.shoes, "shoes")
    )
}