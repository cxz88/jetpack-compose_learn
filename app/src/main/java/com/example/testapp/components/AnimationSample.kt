package com.example.testapp.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationSample() {
    var remember by remember {
        mutableStateOf(false)
    }
    //局部动画
    Column {
        TextButton(onClick = { remember = !remember }) {
            Text(text = "点击试试动画效果")
        }
        AnimatedVisibility(visible = remember
            //展开时候的效果
        , enter = scaleIn()+ slideInVertically
            ///定义纵向也就是y轴的起始展开偏移量
            {

            -30
            } +fadeIn()
        ) {
            Image(painter = painterResource(id = R.drawable.kkk), contentDescription = null)
        }
    }
//    AnimatedVisibility(
//        visible = remember,
//        enter = fadeIn(),
//        exit = fadeOut()
//    ) {
//        //通过获取动画的状态改变子组件的大小颜色
//        val background by transition.animateColor(label = "") { state ->
//            if (state == EnterExitState.Visible) Color.Blue else Color.Gray
//        }
//        Box(modifier = Modifier.size(128.dp).background(background))
//    }
}

@Preview
@Composable
fun AnimationSamplePreview() {
    AnimationSample()
}

