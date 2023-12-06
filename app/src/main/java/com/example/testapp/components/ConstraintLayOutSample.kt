package com.example.testapp.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayOutSample() {
    var checked by remember {
        mutableStateOf(false)
    }
    ConstraintLayout(
        modifier =
        Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp)
    ) {
        val (icon, textMain, text, check) = createRefs()
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = null,
            modifier = Modifier.constrainAs(icon) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                //将左边关联到父组件的左边,并设置为10个像素的margin
                start.linkTo(
                    parent.start,
                    10.dp
                )

            })
        Text(text = "主文本", modifier = Modifier.constrainAs(textMain) {
            start.linkTo(icon.end, 10.dp)
            top.linkTo(parent.top, 20.dp)

        })
        Text(text = "副文本11241234123412351235123551512", modifier = Modifier.constrainAs(text) {
            start.linkTo(textMain.start)
            top.linkTo(textMain.bottom, 20.dp)
            bottom.linkTo(parent.bottom,20.dp)

        })
        Checkbox(checked = checked, onCheckedChange = {
            checked = it
        }, modifier = Modifier.constrainAs(check) {
            //等于          bottom.linkTo(parent.bottom)
            //            top.linkTo(parent.top)
            centerVerticallyTo(parent)
            end.linkTo(parent.end,10.dp)

        })
    }

}

@Preview
@Composable
fun ConstraintLayOutSamplePreview() {
    ConstraintLayOutSample()
}

