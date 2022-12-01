plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("com.google.dagger.hilt.android") version "2.44.2" apply false
    id("com.google.protobuf") version "0.8.17" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0" apply false
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}

