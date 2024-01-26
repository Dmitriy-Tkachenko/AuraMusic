object Dependencies {
    object AndroidX {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val googleMaterial = "com.google.android.material:material:${Versions.googleMaterial}"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    }
}