pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:4.1.3")
            }
        }
    }
}
rootProject.name = "SimpleBux-multiplatform"


include(":androidApp")
include(":shared")

