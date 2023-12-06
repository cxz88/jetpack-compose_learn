package com.example.testapp.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardSample() {
    Card(
        modifier = Modifier.padding(10.dp),
        //布局阴影
        elevation = CardDefaults.cardElevation(5.dp),
        colors = cardColors(
            containerColor = Color.Red, contentColor = Color.Blue,
        ), border = BorderStroke(1.dp, Color.Yellow)
    ) {
        Text(text = "这个一个文字", modifier = Modifier.padding(10.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun CardSamplePreview() {
    CardSample()
}

