package com.example.testapp.components


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AspectRatio
import androidx.compose.material.icons.filled.BedroomBaby
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TabSample() {
    var check by remember {
        mutableIntStateOf(0)
    }
    TabRow(selectedTabIndex = check) {
        Tab(selected = check == 0, onClick = { check = 0 }) {
            Icon(imageVector = Icons.Default.BedroomBaby, contentDescription = null)
            Text(text = "tab1")

        }
        Tab(selected = check == 1,
            onClick = { check = 1 }, icon = {
                Icon(imageVector = Icons.Default.AspectRatio, contentDescription = null)
            }, text = { Text(text = "tab2")})
        LeadingIconTab(
            selected = check == 2,
            onClick = { check = 2 },
            text = { Text(text = "tab3") },
            icon = { Icon(imageVector = Icons.Default.Image, contentDescription = null) })

    }
}

@Preview
@Composable
fun TabSamplePreview() {
    TabSample()
}

