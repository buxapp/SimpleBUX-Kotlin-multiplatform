buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0")
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.4.0")

    }
}
group = "com.getbux.simplebux"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
    }
}
