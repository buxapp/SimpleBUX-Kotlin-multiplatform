plugins {
    id("com.android.application")
    kotlin("android")
}

group = "com.getbux.simplebux"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    add("kotlinCompilerPluginClasspath", "androidx.compose.compiler:compiler:1.0.0-beta06")

    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.activity:activity-ktx:1.2.3")

    implementation("androidx.compose.ui:ui:1.0.0-beta06")
    implementation("androidx.compose.ui:ui-graphics:1.0.0-beta06")
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta06")
    implementation("androidx.compose.foundation:foundation-layout:1.0.0-beta06")
    implementation("androidx.compose.material:material:1.0.0-beta06")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0-beta06")
    implementation("androidx.navigation:navigation-compose:1.0.0-alpha10")
    implementation("dev.chrisbanes.accompanist:accompanist-coil:0.4.0")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.getbux.simplebux.androidApp"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            freeCompilerArgs = listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check",
                "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
            )
        }
    }
}