package com.example.testapp.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogSample() {
    var show by remember {
        mutableStateOf(false)
    }
//
//    Column {
//        TextButton(onClick = {
//            show = true
//        }) {
//            Text(text = "点击展示")
//        }
//        if (show) {
//            Dialog(onDismissRequest =
//            { show = false }) {
//                Surface(
//                    modifier = Modifier
//                        .size(200.dp, 100.dp)
//                        .background(Color.Red)
//                ) {
//                    Column {
//                        Text(text = "提示")
//                    }
//
//                }
//
//            }
//        }
//    }
    //
    Column {
        TextButton(onClick = {
            show = true
        }) {
            Text(text = "点击展示")
        }
        if (show) {
            AlertDialog(onDismissRequest = { /*TODO*/ },
                title = {
                    Text(text = "提示")
                }, confirmButton = {
                    TextButton(onClick = { show = false }) {
                        Text(text = "确认")
                    }
                }, text = {
                    Text(text = "确定关闭么")
                }, dismissButton = {
                    TextButton(onClick = { }) {
                        Text(text = "取消")
                    }
                })
        }
    }
}

@Preview
@Composable
fun DialogSamplePreview() {
    DialogSample()
}

