package com.example.testapp.components


import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonSample() {
//    Row {
//        Button(
//            onClick = {
//                Log.d("--", "被点击了")
//            }, colors = ButtonDefaults.buttonColors(
//                Color.Yellow, disabledContainerColor = Color.Blue
//                , disabledContentColor = Color.White
//
//            ), enabled = false,
//            border = BorderStroke(1.dp, Color.Green)
////        , contentPadding = PaddingValues(1.dp,1.dp,1.dp,1.dp)
//        ) {
//            Text(text = "点击试一下")
//        }
//    }
    Row {
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "你好")
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun ButtonSamplePreview() {
    ButtonSample()
}

