package com.example.testapp.components


import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun PermissionsSample() {
    val rememberPermissionState =
        rememberPermissionState(permission = Manifest.permission.CAMERA)
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "权限获取") })
    }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()
        ) {
            when (rememberPermissionState.status) {
                is PermissionStatus.Denied -> {
                    if (rememberPermissionState.status.shouldShowRationale) {
                        Text(text = "当前未同意相机权限,点击再次获取")
                        TextButton(onClick = {
                            rememberPermissionState.launchPermissionRequest()
                        }) {
                            Text(text = "点击获取相机权限")
                        }
                    } else {
                        Text(text = "相机权限已经禁止")
                        TextButton(onClick = {
                            rememberPermissionState.launchPermissionRequest()
                        }) {
                            Text(text = "点击获取相机权限")
                        }
                    }

                }

                PermissionStatus.Granted -> Text(text = "当前已经同意了相机权限")
            }
        }
    }
}

@Preview
@Composable
fun PermissionsSamplePreview() {
    PermissionsSample()
}

