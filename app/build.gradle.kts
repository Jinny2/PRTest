plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jlleitschuh.gradle.ktlint")
    id("io.gitlab.arturbosch.detekt")
}

android {
    compileSdk = Dependency.AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.prTest"
        minSdk = Dependency.AppConfig.minSdk
        targetSdk = Dependency.AppConfig.targetSdk
        versionCode = Dependency.AppConfig.versionCode
        versionName = Dependency.AppConfig.versionName
        vectorDrawables.useSupportLibrary = true

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
        dataBinding = true
    }

    ktlint {
        disabledRules.set(setOf("final-newline"))
    }
    namespace = "com.example.prTest"
}

dependencies {
    // module
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":presentation"))

    // KTX
    implementation(Dependency.Libraries.KTX.CORE)
    implementation(Dependency.Libraries.KTX.NAVIGATION_FRGMENT)
    implementation(Dependency.Libraries.KTX.NAVIGATION_UI)

    // AndroidX
    implementation(Dependency.Libraries.AndroidX.APP_COMPAT)
    implementation(Dependency.Libraries.AndroidX.MATERIAL)
    implementation(Dependency.Libraries.AndroidX.CONSTRAINT_LAYOUT)

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
}
