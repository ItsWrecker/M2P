import dependencies.PresantationDependencies

plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.kotlinAndroid)
}

android {
    namespace = "com.wrecker.presentation"
    compileSdk = Config.Android.androidCompileSdkVersion

    defaultConfig {
        minSdk = Config.Android.androidMinSdkVersion
        targetSdk = Config.Android.androidTargetVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(Modules.domain))
    implementation(PresantationDependencies.javax)
    implementation(PresantationDependencies.coroutine)
    implementation(PresantationDependencies.hilt)
    kapt(PresantationDependencies.hiltKapt)
    PresantationDependencies.lifeCycle.forEach {
        implementation(it)
    }
}