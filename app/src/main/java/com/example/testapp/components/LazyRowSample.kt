package com.example.testapp.components


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyRowSample() {
    var list = List(100) {
        it
    }
    LazyRow() {
        stickyHeader {
            Text(
                text = "header",
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 20.dp)
                    .background(Color.Red)

            )
        }
        items(list) {
            Text(
                text = "row item$it",
                Modifier
                    .padding(0.dp, 30.dp, 0.dp, 0.dp)
                    .background(Color.Gray)
            )
        }
    }
}

@Preview
@Composable
fun LazyRowSamplePreview() {
    LazyRowSample()
}

