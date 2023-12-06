package com.example.testapp.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DividerSample() {
    Column(
        Modifier
            .size(300.dp)
            .background(color = Color.Yellow),
//        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "第一个", color = Color.Red,
            //占比比重
//            modifier = Modifier.weight(1f)
        )
        //分割线
        Divider(
            thickness = 1.dp ,//分割线高度
            color = Color.Red

        )
        Text(
            text = "第二个", color = Color.Red,

            )
    }
}

@Preview
@Composable
fun DividerSamplePreview() {
    DividerSample()
}

