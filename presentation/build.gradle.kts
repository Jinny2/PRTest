plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jlleitschuh.gradle.ktlint")
    id("io.gitlab.arturbosch.detekt")
}

android {
    compileSdk = Dependency.AppConfig.compileSdk

    defaultConfig {
        minSdk = Dependency.AppConfig.minSdk
        targetSdk = Dependency.AppConfig.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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

    composeOptions {
        kotlinCompilerExtensionVersion = Dependency.AppConfig.compose_compiler
    }

    ktlint {
        disabledRules.set(setOf("final-newline"))
    }
    namespace = "com.example.presentation"
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(mapOf("path" to ":core")))

    // testUnit
    testImplementation(Dependency.Libraries.Test.JUNIT)
    androidTestImplementation(Dependency.Libraries.AndroidTest.TEST)
    androidTestImplementation(Dependency.Libraries.AndroidTest.TEST_CORE)

    // Coroutines
    implementation(Dependency.Libraries.COROUTINES.COROUTINES_KOTLINX)
    implementation(Dependency.Libraries.COROUTINES.COROUTINES_VIEWMODEL)

    // Kakao SDK
    implementation(Dependency.Libraries.KAKAO.KAKAO_SDK)

    // Hilt
    implementation(Dependency.Libraries.HLIT.HLIT)
    kapt(Dependency.Libraries.HLIT.HLIT_COMPILER)

    // KTX
    implementation(Dependency.Libraries.KTX.CORE)
    implementation(Dependency.Libraries.KTX.NAVIGATION_FRGMENT)
    implementation(Dependency.Libraries.KTX.NAVIGATION_UI)
    implementation(Dependency.Libraries.KTX.LIVE_DATA)


    // AndroidX
    implementation(Dependency.Libraries.AndroidX.APP_COMPAT)
    implementation(Dependency.Libraries.AndroidX.MATERIAL)
    implementation(Dependency.Libraries.AndroidX.CONSTRAINT_LAYOUT)

    // compose
    implementation(Dependency.Libraries.COMPOSE.COMPOSE_PREVIEW)
    implementation(Dependency.Libraries.COMPOSE.COMPOSE_TOOL)
    implementation(Dependency.Libraries.COMPOSE.COMPOSE_UI)
    implementation(Dependency.Libraries.COMPOSE.COMPOSE_ACTIVITY)
    implementation(Dependency.Libraries.COMPOSE.COMPOSE_MATERIAL)

    // DataStore
    implementation(Dependency.Libraries.DATASTORE.DATASTORE_PREFERENCES)
    implementation(Dependency.Libraries.DATASTORE.DATASTORE_PREFERENCES_CORE)
}