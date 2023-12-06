package com.example.testapp.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.R

@Composable
fun ImageSample() {
    //从资源文件导入图片
    Image(painter = painterResource(id = R.drawable.kkk), contentDescription = null
//        , modifier = Modifier.size(100.dp)
        //图片的展示方式,平铺,填充,裁剪等等
//    , contentScale = ContentScale.Crop
        //添加一个滤镜
    , colorFilter = ColorFilter.tint(Color.Black, blendMode = BlendMode.Color))
}

@Preview
@Composable
fun ImageSamplePreview() {
    ImageSample()
}

