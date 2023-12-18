package com.example.testapp.components


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BackDropScaffoldSample() {
    var rememberCoroutineScope = rememberCoroutineScope()
    val rememberBackdropScaffoldState =
        rememberBackdropScaffoldState(initialValue = BackdropValue.Concealed)
    BackdropScaffold(scaffoldState = rememberBackdropScaffoldState,appBar = {
        TopAppBar(title = {
            Text(text = "主页")
        }, navigationIcon = {
            IconButton(onClick = {
                if (rememberBackdropScaffoldState.isConcealed) {
                    rememberCoroutineScope.launch {
                        rememberBackdropScaffoldState.reveal()
                    }
                } else {
                    rememberCoroutineScope.launch {
                        rememberBackdropScaffoldState.conceal()
                    }
                }
            }) {
                if (rememberBackdropScaffoldState.isRevealed) {
                    Icon(imageVector = Icons.Default.Minimize, contentDescription = null)
                } else {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                }
            }

        })
    }, frontLayerContent = {
        LazyColumn{
            items(50){
                Text(text = "frontLayerContent $it")
            }
        }

    }, backLayerContent = {
        LazyColumn{
            items(50){
                Text(text = "backLayerContent $it")
            }
        }

    }) {

    }
}

@Preview
@Composable
fun BackDropScaffoldSamplePreview() {
    BackDropScaffoldSample()
}

