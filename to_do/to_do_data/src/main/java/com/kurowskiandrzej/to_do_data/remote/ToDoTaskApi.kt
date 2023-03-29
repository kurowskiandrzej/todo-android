package com.kurowskiandrzej.to_do_data.remote

import com.kurowskiandrzej.core.ApiUrl
import com.kurowskiandrzej.to_do_data.remote.dto.ToDoTasksDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ToDoTaskApi {

    @GET("/api/todo/{listId}")
    suspend fun fetchTasksByListId(
        @Header("Cookie") token: String,
        @Path("listId") listId: Long
    ): ToDoTasksDto

    @POST("/api/todo/{listId}")
    suspend fun postTasksByListId(
        @Header("Cookie") token: String,
        @Path("listId") listId: Long
    )

    @PATCH("/api/todo/{listId}/{taskId}")
    suspend fun patchTask(
        @Header("Cookie") token: String,
        @Path("listId") listId: Long,
        @Path("taskId") taskId: Long
    )

    @DELETE("/api/todo/{listId}/{taskId}")
    suspend fun deleteTask(
        @Header("Cookie") token: String,
        @Path("listId") listId: Long,
        @Path("taskId") taskId: Long
    )

    @DELETE("/api/todo/{listId}/completed")
    suspend fun deleteCompletedTasksFromList(
        @Header("Cookie") token: String,
        @Path("listId") listId: Long
    )

    companion object {
        const val BASE_URL = ApiUrl.BASE_URL
    }
}