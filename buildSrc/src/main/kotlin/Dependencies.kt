object Dependencies {
    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Google {
        const val material = "com.google.android.material:material:${Versions.material}"
        const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Github {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val elmslieCore = "com.github.vivid-money.elmslie:elmslie-core:${Versions.elmslie}"
        const val elmslieAndroid = "com.github.vivid-money.elmslie:elmslie-android:${Versions.elmslie}"
        const val elmslieCoroutines = "com.github.vivid-money.elmslie:elmslie-coroutines:${Versions.elmslie}"
    }

    object Jetbrains {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    }

    object Javax {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }
}