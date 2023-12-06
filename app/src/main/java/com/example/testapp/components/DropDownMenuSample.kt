package com.example.testapp.components


import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun DropDownMenuSample() {
    var expanded by remember {
        mutableStateOf(false)
    }
    Button(onClick = { expanded=true }) {
        Text(text = "快快点我吧")
    }
    DropdownMenu(
        offset = DpOffset(10.dp,10.dp),
        expanded = expanded,
        //在配置properties将点击外层和返回设置为true的时候会回掉这里
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(text = { Text(text = "你好") }, onClick = { expanded = false })
        DropdownMenuItem(text = { Text(text = "世界") }, onClick = { expanded = false })
        DropdownMenuItem(text = { Text(text = "我来了") }, onClick = { expanded = false })

    }
}

@Preview
@Composable
fun DropDownMenuSamplePreview() {
    DropDownMenuSample()
}

