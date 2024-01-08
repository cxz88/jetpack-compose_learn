package com.example.testapp.components


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.testapp.R


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimationSample1() {
    var count by remember {
        mutableIntStateOf(0)
    }
    Row {
        TextButton(onClick = {
            count++
        }) {
            Text(text = "+")
        }
        TextButton(onClick = {
            count--
        }) {
            Text(text = "-")
        }
        AnimatedContent(
            targetState = count, transitionSpec = {
                if (targetState > initialState) {
                    (slideInVertically(animationSpec = tween(1000)) {
                        it  //从哪里开始往目标移动
                    } + fadeIn()).togetherWith(slideOutVertically(animationSpec = tween(1000)) {
                        -it //目标位置
                    } + fadeOut())
                } else {
                    (slideInVertically(animationSpec = tween(1000)) {
                        -it
                    } + fadeIn()).togetherWith(slideOutVertically(animationSpec = tween(1000)) {
                        it
                    } + fadeOut())
                }   //应用一个尺寸变化,不对他们进行裁切
                    .using(SizeTransform(false))
            }, label = ""
        ) {
            Text(text = "当前计数: $it")
        }

    }

}

@Preview
@Composable
fun AnimationSamplePreview1() {
    AnimationSample1()
}

