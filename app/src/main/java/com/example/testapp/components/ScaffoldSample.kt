package com.example.testapp.components


import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardReturn
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedAnimatable")
@Composable
fun ScaffoldSample() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val sharpEdgePercent = -50f
    val roundEdgePercent = 45f
    val animatedProgress = remember {
        Animatable(sharpEdgePercent, roundEdgePercent)
    }
    val rememberCoroutineScope = rememberCoroutineScope()
    val process = animatedProgress.value.roundToInt()
    val fabShape = when {
        process < 0 -> {
            CutCornerShape(abs(process))
        }

        process == roundEdgePercent.toInt() -> {
            CircleShape
        }

        else -> {
            RoundedCornerShape(process)
        }
    }
    val changeShape = {
        val target = animatedProgress.targetValue
        val nextTarget = if (target == roundEdgePercent) {
            sharpEdgePercent
        } else {
            roundEdgePercent
        }
        rememberCoroutineScope.launch {
            animatedProgress.animateTo(
                targetValue = nextTarget,
                animationSpec = TweenSpec(durationMillis = 1000)
            )
        }

    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "主页") },
                colors = TopAppBarDefaults.topAppBarColors(Color.Yellow),
                navigationIcon = {
                    Icon(imageVector = Icons.Default.KeyboardReturn, contentDescription = null)
                },
                actions = {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    Text(text = "添加")
                })
        },
        bottomBar = {
            BottomAppBar(containerColor = Color.Red) {

            }

        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "点击改变形状") },
                icon = { },
                onClick = { changeShape() }, shape = fabShape
            )

        },
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        Text(text = "文本")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldSample1() {
    val data = listOf("资讯", "主页", "我的")
    var check by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        topBar = {

        },
        bottomBar = {
            NavigationBar {
                data.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == check,
                        onClick = { check = index },
                        icon = {
                            BadgedBox(badge = {
                                Text(text = "99+")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.AcUnit,
                                    contentDescription = null
                                )
                            }


                        }, label = {
                            Text(text = item)
                        })
                }

            }
        },

    ) {
        Text(text = "主页内容")
    }

}

@Preview
@Composable
fun ScaffoldSamplePreview() {
    ScaffoldSample1()
}

