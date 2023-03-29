apply {
    from("$rootDir/base-ui-module.gradle")
}
apply(plugin = "org.jetbrains.kotlin.android")

dependencies {

    //Modules
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.toDoDomain))
}