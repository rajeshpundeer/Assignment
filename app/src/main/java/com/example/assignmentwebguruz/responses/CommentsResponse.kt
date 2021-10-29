package com.example.assignmentwebguruz.responses

class CommentsResponse : ArrayList<CommentsResponse.CommentsResponseItem>(){
    public data class CommentsResponseItem(
        val body: String,
        val email: String,
        val id: Int,
        val name: String,
        val postId: Int
    )
}