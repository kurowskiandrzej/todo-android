apply {
    from("$rootDir/base-module.gradle")
}

dependencies {

    // Modules
    "implementation"(project(Modules.appDatabase))
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.toDoDomain))

    // Retrofit
    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.moshiConverter)

    // Room
    "kapt"(Room.roomCompiler)
    "implementation"(Room.roomKtx)
    "implementation"(Room.roomRuntime)
}