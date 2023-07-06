
object Config {

    object Android {
        const val androidMinSdkVersion = 28
        const val androidTargetVersion = 33
        const val androidCompileSdkVersion = 33
        const val androidBuildToolVersion = ""
    }


    object Plugins {
        const val kotlin = "kotlin"
        const val javaLibrary = "java-library"
        const val android = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val navigationSafArgs = "androidx.navigation.safeargs.kotlin"
        const val kotlinKapt = "kotlin-kapt"
        const val dagger = "com.google.dagger.hilt.android"
        const val androidLibrary = "com.android.library"
    }


    const val namespace = "com.wrecker.m2p"

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"


}