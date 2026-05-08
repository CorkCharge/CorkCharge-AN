rootProject.name = "KMP_Corkcharge_AN"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        //maven { url = uri("https://maven.pkg.github.com/kotlin/kotlinx.bits") }
    }
}

include(":composeApp")