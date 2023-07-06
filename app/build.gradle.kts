plugins {
    id(Config.Plugins.android)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.dagger)

}
android {
    namespace = Config.namespace
    compileSdk=Config.Android.androidCompileSdkVersion

    defaultConfig {
        applicationId = Environments.Release.appId
        minSdk = Config.Android.androidMinSdkVersion
        targetSdk = Config.Android.androidTargetVersion
        versionCode = Environments.Release.appVersionCode
        versionName = Environments.Release.appVersionName

        testInstrumentationRunner=Config.testRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.Core.coreKtx)
    implementation(Dependencies.Core.lifecycle)
    implementation(Dependencies.Core.composeActivity)
    implementation(platform(Dependencies.Compose.composeBOM))
    implementation(Dependencies.Compose.composeUI)
    implementation(Dependencies.Compose.composeUIGraphics)
    implementation(Dependencies.Compose.composeMaterial)
    implementation(Dependencies.Compose.composePreview)

    implementation(Dependencies.Inject.hilt)
    kapt(Dependencies.Inject.hiltCompiler)

}