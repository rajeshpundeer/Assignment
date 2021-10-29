package com.example.assignmentwebguruz.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignmentwebguruz.repository.CommentsRepository
import com.example.assignmentwebguruz.responses.CommentsResponse


class CommentsViewModel (application: Application) : AndroidViewModel(application){

    private val repository  = CommentsRepository(application)
    val showProgress : LiveData<Boolean>
    val commentsDataLive : LiveData<CommentsResponse>

    init {
        this.showProgress = repository.showProgress
        this.commentsDataLive  = repository.getCommentsResponse
    }

    fun changeState(){
        repository.changeState()
    }
    fun getCommentsResponse(){
        repository.getComments()
    }
}