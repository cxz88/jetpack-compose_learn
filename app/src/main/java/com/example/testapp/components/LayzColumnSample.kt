package com.example.testapp.components


import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun LazyColumnSample() {
    var itemList by remember {
        mutableStateOf(List(100)
        { index ->
            Item1(title = "第${index}个")
        })
    }
    var rememberScrollState = rememberScrollState()
    var rememberCoroutineScope = rememberCoroutineScope()
    Column(Modifier.verticalScroll(rememberScrollState)) {
        itemList.forEachIndexed { index, item ->
            ListItem(
                //标题内容
                headlineContent = {
                    Text(text = item.title)
                },
                overlineContent = {
                    //标题上方内容
                    Text(text = "overlineContent")
                },
                supportingContent = {
                    //标题下方内容
                    Text(text = "supportingContent")
                },
                //标题前面内容
                leadingContent = {
                    Column(verticalArrangement = Arrangement.SpaceAround) {
                        Icon(
                            imageVector = Icons.Default.AccessAlarm, contentDescription = null,
                        )
                    }
                }, trailingContent = {
                    Row {
                        Text(text = "请选择")
                        Checkbox(checked = item.checked, onCheckedChange = {
                            itemList = itemList.mapIndexed { index1, item1 ->
                                Item1(
                                    item1.title,
                                    if (index == index1)
                                        it
                                    else
                                        item1.checked

                                )
                            }
                        })

                    }
                }, modifier = Modifier.clickable {
                    rememberCoroutineScope.launch {
                        //直接滚动到对应的位置必须向上滑动才能继续继续滚动到对应的位置
//                        rememberScrollState.scrollTo(rememberScrollState.maxValue)
                        //每次都滚动100f,
                        rememberScrollState.scrollBy(100F)
                    }

                }

            )
            //监听空间的生命周期
            DisposableEffect(Unit) {
                Log.d("===", "effect$index")
                onDispose {
                    Log.d("===", "onDispose$index")
                }
            }


        }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnSample11() {
    var list = List(100)
    { index ->
        Item1(title = "第${index}个")
    }
    var rememberLazyListState = rememberLazyListState()
    var rememberCoroutineScope = rememberCoroutineScope()
    LazyColumn(
        state = rememberLazyListState,
    ) {
        stickyHeader {
            Text(text = "这是一个头部", modifier =Modifier.background(Color.Red)
                .border(1.dp, Color.Blue).fillMaxWidth().padding(5.dp))
        }
        items(list) {
            ListItem(
                modifier = Modifier.clickable {
                    rememberCoroutineScope.launch {
                        rememberLazyListState.animateScrollToItem(list.size - 1)
                    }
                },
                //标题内容
                headlineContent = {
                    Text(text = it.title)
                },
                overlineContent = {
                    //标题上方内容
                    Text(text = "overlineContent")
                },
                supportingContent = {
                    //标题下方内容
                    Text(text = "supportingContent")
                },
                //标题前面内容
                leadingContent = {
                    Column(verticalArrangement = Arrangement.SpaceAround) {
                        Icon(
                            imageVector = Icons.Default.AccessAlarm, contentDescription = null,
                        )
                    }
                }, trailingContent = {
                    Row {
                        Text(text = "请选择")

                    }
                })

            //监听空间的生命周期
            DisposableEffect(Unit) {
                Log.d("===", "effect${it.title}")
                onDispose {
                    Log.d("===", "onDispose$it.title")
                }
            }
        }
    }

}

data class Item1(val title: String, var checked: Boolean = false)

@Preview
@Composable
fun LazyColumnSamplePreview() {
    LazyColumnSample11()
}

