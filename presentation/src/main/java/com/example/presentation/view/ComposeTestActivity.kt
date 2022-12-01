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
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JatpackComoseTheme {
        TestApp {
            TestScreenContents()
        }
    }
}
