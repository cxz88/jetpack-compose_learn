package com.example.testapp.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxSample() {
    //其实默认就是Box的布局
//    Box{
//
//        Box(modifier = Modifier
//            .background(Color.Green)
//            .size(200.dp)
//        ) {
//        }
//        //后写的会堆叠到上面来
//        Box(modifier = Modifier
//            .background(Color.Yellow)
//            .size(100.dp)
//            .align(Alignment.Center)
//        ) {
//        }
//
//    }
    BoxWithConstraints {
        //里面可以获取到父级的大小信息
        if (maxWidth>maxHeight) {
            Box(modifier = Modifier
                .background(Color.Green)
                .size(200.dp)
            ) {
            }
        }else{
            Box(modifier = Modifier
                .background(Color.Yellow)
                .size(100.dp)
                .align(Alignment.Center)
            ) {
            }
        }



    }
}

@Preview
@Composable
fun BoxSamplePreview() {
    BoxSample()
}

