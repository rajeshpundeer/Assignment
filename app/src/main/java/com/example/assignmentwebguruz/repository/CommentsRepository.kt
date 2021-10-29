package com.example.assignmentwebguruz.repository

import com.example.assignmentwebguruz.network.BASE_URL
import com.example.assignmentwebguruz.network.ApiNetwork
import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.assignmentwebguruz.responses.CommentsResponse
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CommentsRepository(val application: Application) {
    val getCommentsResponse = MutableLiveData<CommentsResponse>()
    val showProgress = MutableLiveData<Boolean>()
    private val TAG: String = "CommentsRepository"

    fun changeState() {
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }

    fun getComments() {
        showProgress.value = true
        // Networkcall
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(ApiNetwork::class.java)
        service.commentsResponse().enqueue(object :
            Callback<CommentsResponse> {
            override fun onFailure(call: Call<CommentsResponse>, t: Throwable) {
                showProgress.value = false
                Log.d(TAG, "Error :"+t.message+ BASE_URL)
                Toast.makeText(application, "Error while accessing the API", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(
                call: Call<CommentsResponse>,
                response: Response<CommentsResponse>
            ) {
                if (response.code() == 200) {
                    getCommentsResponse.value = response.body()
                    Log.d(TAG, "Response : ${Gson().toJson(response.body())}")
                }
                Log.i(TAG, "onResponse: " + response.code())
                showProgress.value = false
            }
        })
    }


}


