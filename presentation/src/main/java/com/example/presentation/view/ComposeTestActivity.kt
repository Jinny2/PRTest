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
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JatpackComoseTheme {
        TestApp {
            TestScreenContents()
        }
    }
}
