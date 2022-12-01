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

    ktlint {
        disabledRules.set(setOf("final-newline"))
    }
    namespace = "com.example.domain"
}

dependencies {

    // Coroutines
    implementation(Dependency.Libraries.COROUTINES.COROUTINES_KOTLINX)
    implementation(Dependency.Libraries.COROUTINES.COROUTINES_VIEWMODEL)

    // Kakao SDK
    implementation(Dependency.Libraries.KAKAO.KAKAO_SDK)

    // Hilt
    implementation(Dependency.Libraries.HLIT.HLIT)
    kapt(Dependency.Libraries.HLIT.HLIT_COMPILER)

    // testUnit
    testImplementation(Dependency.Libraries.Test.JUNIT)
    androidTestImplementation(Dependency.Libraries.AndroidTest.TEST)
    androidTestImplementation(Dependency.Libraries.AndroidTest.TEST_CORE)
}
