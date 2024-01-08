package com.example.testapp.components


import android.util.Log
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver

//生命周期
@Composable
fun SideEffectsSample() {
    var count by remember {
        mutableIntStateOf(1)
    }
    val lifecycleOwner = LocalLifecycleOwner.current
    Button(onClick = { count++ }) {
        Text("+")
    }
//    LaunchedEffect(Unit){
//        //由于unit是一个单例所有在整个生命周日中只会执行一次
//    }
//    LaunchedEffect(count){
//        //每次count值变化都会执行,如果变化多次会取消旧的,直接执行最新的
//    }
    if (count < 3) {
        DisposableEffect(count) {
            //作用和上面一样,只是多了一个销毁方法
            Log.d("===", "count:$count")
            val lifecycleEventObserver = LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_START) {
                    //开始播放
                } else if (event == Lifecycle.Event.ON_PAUSE) {
                    //暂停播放

                }
            }
            //注册观察器
            lifecycleOwner.lifecycle.addObserver(lifecycleEventObserver)
            onDispose {
                Log.d("===", "销毁")
                //销毁观察器
                lifecycleOwner.lifecycle.removeObserver(lifecycleEventObserver)
                //销毁时候
            }
        }
    }
//    DisposableEffect(Unit) {
//        //作用和上面一样,只是多了一个销毁方法
//        Log.d("===", "count1:$count")
//        onDispose {
//            Log.d("===", "销毁1")
//            //销毁时候
//        }
//    }

}

@Preview
@Composable
fun SideEffectsSamplePreview() {
    SideEffectsSample()
}

