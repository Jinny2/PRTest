package com.example.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ComposeTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JatpackComoseTheme {
                // A surface container using the 'background' color from the theme
                DefaultPreview()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember {
        mutableStateOf(value = false)
    }
    val backgroundColor by animateColorAsState(
        if (isSelected) Color.Red else Color.Transparent
    )

    Text(
        text = "Hello $name!",
        modifier = Modifier
            .padding(10.dp)
            .background(color = backgroundColor)
            .clickable(onClick = {
                isSelected = !isSelected
            }),
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun TestApp(content: @Composable () -> Unit) {
    JatpackComoseTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun TestScreenContents(texts: List<String> = List(size = 1000) { "Hi Compose $it" }) {
    val count = remember { mutableStateOf(value = 0) }

    Column(modifier = Modifier.fillMaxHeight()) {

        NameList(texts, Modifier.weight(weight = 0.9f))

//        Column(modifier = Modifier.weight(weight = 1f)) {
//            texts.forEach {
//                Greeting(it)
//                Divider(color = Color.Red)
//            }
//        }
        CounterButton(count.value, Modifier.weight(weight = 0.1f)) { newCnt ->
            count.value = newCnt
        }
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(items = names) { index, item ->
            Log.d("NameList", " index :$index , item : $item")
            Greeting(item)
            Divider(color = Color.Red)
        }
    }
}

@Composable
fun NameCard(modifier: Modifier = Modifier) {
    Row {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
        }
        Column() {
            Text(text = "안녕 하세요", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun CounterButton(count: Int, modifier: Modifier = Modifier, updateCount: (Int) -> Unit) {
    Log.d("check", "CounterButton1")
    Button(
        onClick = { updateCount(count + 1) },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = if (count > 5) Color.Green else Color.LightGray)
    ) {
        Log.d("check", "Click1 :$count")
        Text(text = "Clicked Count: $count")
    }
}

@Composable
fun CounterButton2(count: MutableState<Int>) {
    Log.d("check", "CounterButton2")
    Button(onClick = { count.value = count.value + 1 }) {
        Log.d("check", "Click2 :${count.value}")
        Text(text = "Clicked Count2: ${count.value}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JatpackComoseTheme {
        TestApp {
            TestScreenContents()
        }
    }
}
