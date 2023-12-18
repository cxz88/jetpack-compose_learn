package com.example.testapp.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScaffoldSample() {
    var rememberBottomSheetScaffoldState = rememberBottomSheetScaffoldState()
    val rememberCoroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(scaffoldState = rememberBottomSheetScaffoldState, sheetContent = {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxWidth()
                .height(
                    100.dp
                )
        ) {
            Text(text = "未来即将到来")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "你好,世界")
            Button(onClick = {
                rememberCoroutineScope.launch {
                    rememberBottomSheetScaffoldState.bottomSheetState.partialExpand()
                }
            }) {
                Text(text = "关闭")
            }
        }

    }, sheetPeekHeight = 100.dp) {


    }
}

@Preview
@Composable
fun BottomSheetScaffoldSamplePreview() {
    BottomSheetScaffoldSample()
}

