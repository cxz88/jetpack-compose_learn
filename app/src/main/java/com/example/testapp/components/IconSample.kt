package com.example.testapp.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testapp.R

@Composable
fun IconSample() {
    //从谷歌资料库中获取
    Icon(imageVector = Icons.Default.Translate, contentDescription = null,
//        //设置颜色
        tint = Color.Red)
//    Icon(painter = painterResource(id = R.drawable.ic_android_black_24dp), contentDescription = null)
//    IconButton(onClick = { /*TODO*/ }) {
//        Icon(painter = painterResource(id = R.drawable.ic_android_black_24dp), contentDescription = null)
//
//    }

}

@Preview
@Composable
fun IconSamplePreview() {
    IconSample()
}

