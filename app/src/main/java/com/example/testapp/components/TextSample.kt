package com.example.testapp.components

import android.util.Log
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextSample() {
//    Text(text = "你好,世界")
    //从字符串资源文件中进行读取
//    Text(
//        text = stringResource(id = R.string.s_text),
//        fontSize = 10.em,
//        fontStyle = FontStyle.Italic,  //是否是斜体还是正常字体
//        fontWeight = FontWeight.Bold,  //字体粗细
//        fontFamily = FontFamily.Cursive,  //字体名称
//        letterSpacing = 1.5F.em,  //文字间距
////        textDecoration = TextDecoration.LineThrough //文字装饰线,例如下划线,删除线之列的
//        textDecoration = TextDecoration.combine(
//            listOf(
//                TextDecoration.LineThrough,
//                TextDecoration.Underline
//            )
//        ), //文字装饰线,例如下划线,删除线之列的,多个组合
//        textAlign = TextAlign.Left, //文字对其方式
//        lineHeight = 100.sp, //行高
//        maxLines = 1, //最大行数
//        overflow = TextOverflow.Ellipsis //文字超出的处理方式
//    )
    //长按复制
//    SelectionContainer {
//        Text(text = "长按复制")
//    }
    //可以点击的文本
//    ClickableText(text = buildAnnotatedString {
//        append("123")
//        withStyle(style = SpanStyle(color = Color.Red)) {
//            append("456")
//        }
//    }) {
//        //it为当前点击的文字的下标
//        Log.d("===", "你点击到了我了$it")
//    }
    val annotatedString = buildAnnotatedString {
        append("点击登录代表宁已经同意")
        pushStringAnnotation("baidu", "http://www.baidu.com")
        withStyle(
            SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("用户协议")
        }
        pop()
        append("和")
        pushStringAnnotation("google", "http://www.google.com")
        withStyle(
            SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("隐私政策")
        }
        pop()
    }
    ClickableText(text = annotatedString) {
        annotatedString.getStringAnnotations("baidu", it, it)
            .firstOrNull()
            ?.let { a ->
                Log.d("--", "你点击了${a.item}")
            }
        annotatedString.getStringAnnotations("google", it, it)
            .firstOrNull()
            ?.let { a ->
                Log.d("--", "你点击了${a.item}")
            }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun TextView() {
    TextSample()

}