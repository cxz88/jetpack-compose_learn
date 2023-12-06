package com.example.testapp.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ColumnSample() {
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
        Text(
            text = "第二个", color = Color.Red,
            modifier = Modifier.
                //比重,和是否剩余全部填充
            weight(1800f,false)
        )
    }
}

@Preview
@Composable
fun ColumnSamplePreview() {
    ColumnSample()
}

