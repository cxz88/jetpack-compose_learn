package com.example.testapp.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StateSample() {
    var count by remember {
        mutableIntStateOf(1)
    }
    val str = buildAnnotatedString {
        append("当前计数$count")
    }
    ClickableText(text = str) {
        count++

    }
}

@Preview
@Composable
fun StateSamplePreview() {
    StateSample()
}

