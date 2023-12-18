package com.example.testapp.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.R

@Composable
fun SurfaceSample() {
    Surface(
        //RectangleShape 矩形
        //RoundedCornerShape 圆角
        //CutCornerShape 切边
        shape = CircleShape,
        //设置抬高
//        shadowElevation = 10.dp,//向下的阴影
//        tonalElevation = 300.dp,
        color = Color.Red,
        border = BorderStroke(10.dp, Color.Gray)
        ) {
        Image(painter = painterResource(id = R.drawable.kkk), contentDescription = null)
    }
}

@Preview
@Composable
fun SurfaceSamplePreview() {
    SurfaceSample()
}

