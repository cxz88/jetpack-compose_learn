package com.example.testapp.components


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.material.BadgedBox
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldSampleCopy() {
    val data = listOf(
        "主页" to Icons.Default.Home,
        "信用卡" to Icons.Default.CardGiftcard,
        "我的" to Icons.Default.AccountBox
    )
    var check by remember {
        mutableIntStateOf(0)
    }
    var rememberCoroutineScope = rememberCoroutineScope()
    var rememberScaffoldState = rememberScaffoldState()
//    Snackbar {
//
//    }
    Scaffold(
        scaffoldState = rememberScaffoldState,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        rememberCoroutineScope.launch { rememberScaffoldState.drawerState.open() }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                    }
                }, title = {
                    Text(text = "破解神器")
                },
                backgroundColor = Color.Black,
                actions = {
                    IconButton(onClick = {
                        rememberCoroutineScope.launch {
                            rememberScaffoldState.snackbarHostState.showSnackbar(
                                "添加成功", actionLabel = "好"
                            )
                        }
                    }) {
                        Row {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null)
                            Text(text = "添加")
                        }
                    }
                }

            )

        },
        bottomBar = {
            BottomNavigation(backgroundColor = Color.Red) {
                data.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = index == check,
                        onClick = { check = index },
                        icon = {

                            BadgedBox(badge = {
                                Text(text = "1+")
                            }) {
                                Icon(imageVector = item.second, contentDescription = null)
                            }
                        },
                        label = {
                            Text(text = item.first)
                        })
                }
            }
        },
        //侧边栏
        drawerContent = {
            Text(text = "第一个")
        },
        drawerBackgroundColor = Color.Red,
        drawerScrimColor = Color.Blue,
        drawerContentColor = Color.Yellow,

        ) {
        Text(text = "主内容")
    }
}

@Preview
@Composable
fun ScaffoldSampleCopyPreview() {
    ScaffoldSampleCopy()
}

