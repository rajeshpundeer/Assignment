package com.example.assignmentwebguruz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentwebguruz.R
import com.example.assignmentwebguruz.adapter.CommentsAdapter
import com.example.assignmentwebguruz.databinding.ActivityMainBinding
import com.example.assignmentwebguruz.responses.CommentsResponse
import com.example.assignmentwebguruz.viewModel.CommentsViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CommentsViewModel
    private lateinit var commentslist: ArrayList<CommentsResponse.CommentsResponseItem>
    private lateinit var commentsAdapter :CommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(CommentsViewModel::class.java)


        // bind RecyclerView
        val recyclerView: RecyclerView = activityMainBinding.rvComments
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        //calling Comments Api
        viewModel.getCommentsResponse()

        //Getting Live data from Comments Api
        viewModel.commentsDataLive.observe(this, Observer {
            commentslist = ArrayList()

            if(it.isNotEmpty())
            {
               commentslist.addAll(it)
               commentsAdapter = CommentsAdapter(this, commentslist)
                recyclerView.adapter = commentsAdapter
            }
        })
    }


}