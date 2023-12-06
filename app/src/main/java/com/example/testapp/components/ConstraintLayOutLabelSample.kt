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
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet

@Composable
fun ConstraintLayOutLabelSample() {
    var checked by remember {
        mutableStateOf(false)
    }
    val constraintSet = ConstraintSet {
        val icon = createRefFor("icon")
        val textMain = createRefFor("textMain")
        val text = createRefFor("text")
        val check = createRefFor("check")
        constrain(icon) {
            centerVerticallyTo(parent)
            start.linkTo(parent.start, 10.dp)
        }
        constrain(textMain) {
            start.linkTo(icon.end, 10.dp)
            top.linkTo(parent.top, 10.dp)
        }
        constrain(text) {
            start.linkTo(textMain.start)
            top.linkTo(textMain.bottom, 10.dp)
            bottom.linkTo(parent.bottom, 10.dp)
        }
        constrain(check) {
            end.linkTo(parent.end, 10.dp)
            centerVerticallyTo(parent)
        }

    }
    ConstraintLayout(
        modifier =
        Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp), constraintSet = constraintSet
    ) {
        Icon(
            imageVector = Icons.Default.AccountBox,
            contentDescription = null,
            modifier = Modifier.layoutId("icon")
        )
        Text(text = "主文本", modifier = Modifier.layoutId("textMain"))
        Text(text = "副文本11241234123412351235123551512", modifier = Modifier.layoutId("text"))
        Checkbox(checked = checked, onCheckedChange = {
            checked = it
        }, modifier = Modifier.layoutId("check"))
    }

}

@Preview
@Composable
fun ConstraintLayOutLabelSamplePreview() {
    ConstraintLayOutLabelSample()
}

