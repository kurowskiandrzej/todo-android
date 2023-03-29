package com.kurowskiandrzej.to_do_data.remote

import com.kurowskiandrzej.core.ApiUrl
import com.kurowskiandrzej.to_do_data.remote.dto.ToDoListDto
import com.kurowskiandrzej.to_do_data.remote.dto.ToDoListsDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ToDoListApi {

    @GET("/api/todo")
    suspend fun fetchTodoLists(
        @Header("Cookie") token: String
    ): ToDoListsDto

    @POST("/api/todo")
    suspend fun postToDoList(
        @Header("Cookie") token: String,
        @Body toDoListName: Map<String, String>
    ): ToDoListDto

    @PATCH("/api/todo/{listId}")
    suspend fun patchList(
        @Header("Cookie") token: String,
        @Path("listId") listId: Long
    )

    @DELETE("/api/todo/{listId}")
    suspend fun deleteListById(
        @Header("Cookie") token: String,
        @Path("listId") listId: Long
    )

    companion object {
        const val BASE_URL = ApiUrl.BASE_URL
    }
}