package com.example.testapp.components

/**
 * @author chenxinzhi
 * @date 2023/11/30
 */

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ModifierSample() {
    Text(
        text = "中国人",
        modifier =
        //注意先后顺序很重要,否则会导致不是你想要的结果
        Modifier.border(1.dp, Color.Red)
            .background(Color.Blue)
            .padding(10.dp)
            .clickable {
                Log.d("===","点击了中国人")
            }

    )
}

@Preview
@Composable
fun ModifierSamplePreview() {
    ModifierSample()
}

