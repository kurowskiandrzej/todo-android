apply {
    from("$rootDir/base-module.gradle")
}

dependencies {

    // OkHttp
    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.okHttpLoggingInterceptor)

    // Test
    "implementation"(Testing.junit4)
    "implementation"(Testing.truth)
}