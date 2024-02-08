plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileSdkVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentRunner
    }

    buildFeatures {
        viewBinding = true
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

    implementation(project(Modules.moduleInjector))
    implementation(project(Modules.Screens.music))
    implementation(project(Modules.Features.musicApi))
    implementation(project(Modules.Features.musicImpl))
    implementation(project(Modules.Features.thumbnailApi))
    implementation(project(Modules.Features.thumbnailImpl))
    implementation(project(Modules.Data.musicApi))
    implementation(project(Modules.Data.musicImpl))
    implementation(project(Modules.Data.thumbnailApi))
    implementation(project(Modules.Data.thumbnailImpl))

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.constraintlayout)

    implementation(Dependencies.Google.material)
    implementation(Dependencies.Google.dagger)
    kapt(Dependencies.Google.daggerCompiler)

    implementation(Dependencies.Github.elmslieCore)
    implementation(Dependencies.Github.elmslieAndroid)
    implementation(Dependencies.Github.elmslieCoroutines)

    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.junitExt)
    androidTestImplementation(Dependencies.Test.espresso)
}