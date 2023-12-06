package com.example.testapp.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListItemSample() {
    var itemList by remember {
        mutableStateOf(List(5)
        { index ->
            Item(title = "第${index}个")
        })
    }
    Column {
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
                                Item(
                                    item1.title,
                                    if (index == index1)
                                        it
                                    else
                                        item1.checked

                                )
                            }
                        })

                    }
                }

            )


        }


    }
}

data class Item(val title: String, var checked: Boolean = false)

@Preview
@Composable
fun ListItemSamplePreview() {
    ListItemSample()
}

