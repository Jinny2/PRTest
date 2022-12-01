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
