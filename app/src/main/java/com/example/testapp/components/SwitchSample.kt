package com.example.testapp.components


import androidx.compose.material3.Switch
import androidx.compose.runtime.*

import androidx.compose.ui.tooling.preview.Preview

/**
 * 开关
 */
@Composable
fun SwitchSample() {
    var checked by remember {
        mutableStateOf(false)
    }
    Switch(checked = checked, onCheckedChange = {
        checked = it
    })
}

@Preview
@Composable
fun SwitchSamplePreview() {
    SwitchSample()
}

