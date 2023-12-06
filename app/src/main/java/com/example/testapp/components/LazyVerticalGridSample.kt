package com.example.testapp.components


import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LazyVerticalGridSample() {
    var list = List(100) {
        it
    }
    LazyVerticalGrid(
        columns =
        //设置单元格是固定的还是自适应的
        GridCells.Fixed(2),
    ) {
        items(list) {
            Card {
                Text(text = "当前是第${it}个")
            }
        }
    }
}

@Preview
@Composable
fun LazyVerticalGridSamplePreview() {
    LazyVerticalGridSample()
}

