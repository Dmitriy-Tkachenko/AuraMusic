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
    implementation(project(Modules.Features.thumbnailApi))
    implementation(project(Modules.Data.thumbnailApi))
    implementation(project(Modules.moduleInjector))

    implementation(Dependencies.Javax.inject)
}