package com.example.testapp.components


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.testapp.R

@Composable
fun CanvasSample() {
//    with(LocalContext.current){
//
//    }

    val image: ImageBitmap = ImageBitmap.imageResource(id = R.drawable.kkk)
    Canvas(modifier = Modifier.size(500.dp,500.dp)) {
        drawImage(
            image,
            //原始图片的开始位置
            srcOffset = IntOffset(0, 0),
            srcSize = IntSize(3072, 2046),
            //展示的时候的开始位置
            dstOffset = IntOffset(50, 100),
            //原有基础上缩小4倍
            dstSize = IntSize(3072, 2046).div(4)
        )
        drawLine(Color.Red, Offset(0F, 0F), Offset(100F, 200F), 10F, StrokeCap.Round)
        drawRect(Color.Blue, Offset(500F, 1000F), Size(100F, 100F))
        drawRoundRect(
            Color.Yellow, Offset(800F, 1000F), Size(100F, 100F), CornerRadius(5f)
        )
        drawCircle(Color.Black, style = Stroke(width = 40F))
        drawOval(Green, size = Size(100F, 80F))
        drawPoints(listOf(Offset(1F, 1F), Offset(80f, 80f)), PointMode.Points, Gray)
        drawArc(Red, 0F, -180F, true)
    }
}

@Preview
@Composable
fun CanvasSamplePreview() {
    CanvasSample()
}

