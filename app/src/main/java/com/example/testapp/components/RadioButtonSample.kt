package com.example.testapp.components


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

//选择框
@Composable
fun RadioButtonSample() {
    //单选框
//    var checked by remember {
//        mutableStateOf(false)
//    }
//    RadioButton(selected = checked, onClick = { checked = !checked })
    var checkList by remember {
        mutableStateOf(listOf(false, false))
    }
    Column {
        checkList.forEachIndexed { index, item ->
            RadioButton(selected = item, onClick = {
                checkList = List(checkList.size) { i ->
                    i == index
                }
            })

        }
    }


}

@Preview
@Composable
fun RadioButtonSamplePreview() {
    RadioButtonSample()
}

