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
