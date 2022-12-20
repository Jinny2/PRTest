object Dependency {
    object AppConfig {
        const val compileSdk = 33
        const val minSdk = 28
        const val targetSdk = 33
        const val versionCode = 100
        const val versionName = "1.0.0"
        const val compose_compiler = "1.3.2"
    }

    object Libraries {

        object AndroidX { // AndroidX
            const val APP_COMPAT = "androidx.appcompat:appcompat:1.4.2"
            const val MATERIAL = "com.google.android.material:material:1.6.1"
            const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.4"
        }

        object KTX {   // KTX
            const val CORE = "androidx.core:core-ktx:1.7.0"
            const val NAVIGATION_FRGMENT = "androidx.navigation:navigation-fragment-ktx:2.5.1"
            const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:2.5.1"
            const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
        }

        object HLIT { // HLIT
            const val HLIT = "com.google.dagger:hilt-android:2.44.2"
            const val HLIT_COMPILER = "com.google.dagger:hilt-compiler:2.44.2"
        }

        object KAKAO { // KAKAO
            const val KAKAO_SDK = "com.kakao.sdk:v2-user:2.11.0"
        }

        object COROUTINES { // COROUTINES
            const val COROUTINES_KOTLINX = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
            const val COROUTINES_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
        }

        object COMPOSE { // COMPOSE
            const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:1.3.1"
            const val COMPOSE_TOOL = "androidx.compose.ui:ui-tooling:1.3.1"
            const val COMPOSE_UI = "androidx.compose.ui:ui:1.3.1"
            const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:1.6.1"
            const val COMPOSE_MATERIAL = "androidx.compose.material:material:1.3.1"
        }

        object DATASTORE { // DATASTORE
            const val DATASTORE_PREFERENCES = "androidx.datastore:datastore-preferences:1.0.0"
            const val DATASTORE_PREFERENCES_CORE = "androidx.datastore:datastore-preferences-core:1.0.0"
        }

        object Test { // Test
            const val JUNIT = "junit:junit:4.13.2"
        }

        object AndroidTest {  // Android Test
            const val TEST = "androidx.test.ext:junit:1.1.3"
            const val TEST_CORE = "androidx.test.espresso:espresso-core:3.4.0"
        }
    }
}

