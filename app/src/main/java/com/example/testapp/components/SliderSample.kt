package com.example.testapp.components


import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SliderSample() {
//    var value by remember {
//        mutableFloatStateOf(0f)
//    }
//    Slider(value = value, onValueChange = {
//        value = it
//    },
//        //定义在拖动的时候value值的区间范围
//        valueRange = 0.1F..0.6F,
//        steps = 4 //定义步长
//    )
    //带有进度范围的进度条
    var values by remember {
        mutableStateOf(0.1F..0.2F)
    }
    RangeSlider(
        //区间范围
        value = values, onValueChange = {
        values =it
    })
}

@Preview
@Composable
fun SliderSamplePreview() {
    SliderSample()
}

