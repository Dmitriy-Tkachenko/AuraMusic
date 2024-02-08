object Modules {
    const val moduleInjector = ":module_injector"

    object Core {
        const val res = ":core:res"
        const val utils = ":core:utils"
    }

    object Data {
        const val musicApi = ":data:music:api"
        const val musicImpl = ":data:music:impl"
        const val thumbnailApi = ":data:thumbnail:api"
        const val thumbnailImpl = ":data:thumbnail:impl"
    }

    object Features {
        const val musicApi = ":features:music:api"
        const val musicImpl = ":features:music:impl"
        const val thumbnailApi = ":features:thumbnail:api"
        const val thumbnailImpl = ":features:thumbnail:impl"
    }

    object Screens {
        const val music = ":screens:music"
    }
}