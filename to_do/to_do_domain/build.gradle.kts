apply {
    from("$rootDir/base-module.gradle")
}

dependencies {

    // Modules
    "implementation"(project(Modules.core))
    "implementation"(Coroutines.coroutines)
}