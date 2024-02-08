plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "ru.tk4dmitriy.data.thumbnail.impl"
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        minSdk = Config.minSdkVersion

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
        jvmTarget = Config.jvmTarget
    }
}

dependencies {
    implementation(project(Modules.Data.thumbnailApi))

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.Google.dagger)
    kapt(Dependencies.Google.daggerCompiler)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.junitExt)
}