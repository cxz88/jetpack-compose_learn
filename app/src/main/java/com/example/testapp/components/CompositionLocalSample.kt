package com.example.testapp.components


import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

data class User(val name: String)

val LocalCompositionLocal = compositionLocalOf<User> { error("user 为空") }

@Composable
fun CompositionLocalSample() {

    val rememberNavController = rememberNavController()
    CompositionLocalProvider(LocalCompositionLocal provides User("小明")) {
        NavHost(navController = rememberNavController, startDestination = "Home") {
            composable("Home") {
                HomeScreen {
                    rememberNavController.navigate("Detail")
                }
            }
            composable("Detail") {
                DetailScreen()
            }
        }
    }

}

@Composable
fun HomeScreen(action: () -> Unit) {
    Column {
        Text(text = "主页${LocalCompositionLocal.current.name}")
        TextButton(onClick = { action() }) {
            Text(text = "点我跳转到详情")
        }
    }

}

@Composable
fun DetailScreen() {
    Text(text = "详情${LocalCompositionLocal.current.name}")
}

@Preview
@Composable
fun CompositionLocalSamplePreview() {
    CompositionLocalSample()
}

