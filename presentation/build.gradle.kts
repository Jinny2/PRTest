plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id ("org.jlleitschuh.gradle.ktlint")
}

android {
    namespace = "com.example.presentation"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        compose = true
        dataBinding = true
    }
}


dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    // testUnit
    testImplementation(Libraries.Test.JUNIT)
    androidTestImplementation(Libraries.AndroidTest.TEST)
    androidTestImplementation(Libraries.AndroidTest.TEST_CORE)

    // Coroutines
    implementation(Libraries.COROUTINES.KOTLIN_COROUTINES)

    // Kakao SDK
    implementation(Libraries.KAKAO.KAKAO_SDK)

    // Hilt
    implementation(Libraries.HLIT.HLIT)
    kapt(Libraries.HLIT.HLIT_COMPILER)

    // KTX
    implementation implementation (Libraries.KTX.CORE)
    implementation implementation (Libraries.KTX.NAVIGATION_FRGMENT)
    implementation implementation (Libraries.KTX.NAVIGATION_UI)

    // AndroidX
    implementation implementation (Libraries.AndroidX.APP_COMPAT)
    implementation implementation (Libraries.AndroidX.MATERIAL)
    implementation implementation (Libraries.AndroidX.CONSTRAINT_LAYOUT)

    // compose
    implementation (Libraries.COMPOSE.composeLibraries)
}