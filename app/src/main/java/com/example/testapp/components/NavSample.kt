package com.example.testapp.components

/**
 * @author chenxinzhi
 * @date 2023/12/18
 */

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.util.LocalePreferences.FirstDayOfWeek
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavSample() {
    val rememberNavController = rememberNavController()
    NavHost(navController = rememberNavController, startDestination = "First") {
        composable("First") {
            FirstScreen {
                rememberNavController.navigate("Two/小明/18")
            }
        }
        composable("Two/{name}/{age}", arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
            }, navArgument("age") {
                type = NavType.IntType
            }
        )) {
            val name = it.arguments?.getString("name")
            val age = it.arguments?.getInt("age")
            TwoScreen(name, age) {
                rememberNavController.navigate("Three")  //没有传参数使用默认值
                //在跳转到 Second 之前 ，关掉所有页面直到 First
//                rememberNavController.navigate("Three") {
//                    popUpTo("First")
//                }
//
////在跳转到 Second 之前 ，关掉所有页面直到 First，包括 First 页面
//                rememberNavController.navigate("Three") {
//                    popUpTo("First") { inclusive = true }
//                }
//
////在跳转到 Second  且只允许出现一个页面
//                rememberNavController.navigate("Three") {
//                    launchSingleTop = true
//                }
            }
        }
        composable("Three?name={name}&age={age}", arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = "小明"
                nullable = true
            },
            navArgument("age") {
                type = NavType.IntType
                defaultValue = 15
//                nullable = true  int类型不可为空
            }
        )) {
            val name = it.arguments?.getString("name")
            val age = it.arguments?.getInt("age")
            ThreeScreen(name, age) {
                rememberNavController.popBackStack("First", false)
            }
        }
    }
}

@Composable
fun FirstScreen(toSec: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()

            .border(10.dp, Color.Yellow)
            .background(color = Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = "当前为第一页")
        Button(onClick = {
            toSec()
        }) {
            Text("点击跳转到下一页")
        }
    }

}

@Composable
fun TwoScreen(name: String?, age: Int?, toSec: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
            .border(10.dp, Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = "当前为第二页$name $age")
        Button(onClick = {
            toSec()
        }) {
            Text("点击跳转到下一页")
        }
    }
}

@Composable
fun ThreeScreen(name: String?, age: Int?, toSec: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
            .border(10.dp, Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(text = "当前为第三页${name} $age")
        Button(onClick = {
            toSec()
        }) {
            Text("点击返回到首页")
        }
    }
}

@Preview
@Composable
fun NavSamplePreview() {
    NavSample()
}

