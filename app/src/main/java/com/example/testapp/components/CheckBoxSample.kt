package com.example.testapp.components


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

//多选框
@Composable
fun CheckBoxSample() {
    var checkList by remember {
        mutableStateOf(listOf(false, false))
    }
    Column {
        checkList.forEachIndexed { index, item ->
            Checkbox(checked = item, onCheckedChange = {
                checkList = checkList.mapIndexed { i, ite ->
                    if (i == index) {
                        !ite
                    } else {
                        ite
                    }
                }
            })

        }
    }
}

@Preview
@Composable
fun CheckBoxSamplePreview() {
    CheckBoxSample()
}

