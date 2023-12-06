package com.example.testapp.components


import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
//进度条
@Composable
fun ProcessIndicatorSample() {
    //圆形的进度条
//    CircularProgressIndicator(
//        color = Color.Green,
//        //如果给了进度他就不会再转了
//        progress = 0.5F
//    )
//    LinearProgressIndicator(
//        //完成进度的颜色
//        color = Color.Green,
//        //外层的颜色
//        trackColor = Color.Black,
//
//    )
    LinearProgressIndicator(progress = 0.1F

    ,)
}

@Preview
@Composable
fun ProcessIndicatorSamplePreview() {
    ProcessIndicatorSample()
}

