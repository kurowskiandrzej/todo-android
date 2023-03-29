package com.kurowskiandrzej.core.data.remote.api_call_handler

import com.kurowskiandrzej.core.BuildConfig
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> apiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    block: suspend () -> T
): Result<T> {
    return withContext(dispatcher) {
        try {
            Result.success(block.invoke())
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) e.printStackTrace()
            Result.failure(e)
        }
    }
}