package com.example.assignmentwebguruz.network

import retrofit2.Call
import retrofit2.http.*
import com.example.assignmentwebguruz.responses.CommentsResponse

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

interface ApiNetwork {

    @GET("comments")
    fun commentsResponse(
    ): Call<CommentsResponse>

}
