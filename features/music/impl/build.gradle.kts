plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(Config.jvmToolchain)
}

dependencies {
    implementation(project(Modules.Features.musicApi))
    implementation(project(Modules.Data.musicApi))
    implementation(project(Modules.moduleInjector))

    implementation(Dependencies.Javax.inject)
}
