package com.example.testapp.components


import android.util.Log
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextFieldSample() {
    var name by remember {
        mutableStateOf("")
    }
    TextField(
        value = name,
        onValueChange = {
            name = it
        },
        label = {
            Text(text = "姓名")
        },
        placeholder = {
            Text(text = "请输入姓名")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
        },
        keyboardOptions = KeyboardOptions(
            //键盘上面最后一行的右下角显示完成
            imeAction = ImeAction.Done,
            //设置键盘的格式
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                Log.d("===", "用户点击了完成")
            }
        ),

        //设置为单行输入框
        singleLine = true,

    )
}

@Preview
@Composable
fun TextFieldSamplePreview() {
    TextFieldSample()
}

