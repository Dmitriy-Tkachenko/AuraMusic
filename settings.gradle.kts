pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io" )
    }
}

rootProject.name = "AuraMusic"
include(":app")
include(":module_injector")
include(":core:res")
include(":data:music:api")
include(":data:music:impl")
include(":features:music:api")
include(":features:music:impl")
include(":screens:music")
include(":core:utils")
include(":features:thumbnail:api")
include(":features:thumbnail:impl")
include(":data:thumbnail:impl")
include(":data:thumbnail:api")
