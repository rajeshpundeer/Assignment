package com.example.assignmentwebguruz.adapter

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentwebguruz.R
import com.example.assignmentwebguruz.databinding.CommentsItemListBinding
import com.example.assignmentwebguruz.responses.CommentsResponse
import com.example.assignmentwebguruz.ui.VowelsActivity

class CommentsAdapter(
    private val mContext: Activity,
    var commentsList: ArrayList<CommentsResponse.CommentsResponseItem>,
) :
    RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    var vowelString:String= " ";
    inner class CommentsViewHolder(val commentsItemListBinding : CommentsItemListBinding)
        : RecyclerView.ViewHolder(commentsItemListBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val commentsItemListBinding : CommentsItemListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.comments_item_list, parent, false
        )
       
        return CommentsViewHolder(commentsItemListBinding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var commentsList: CommentsResponse.CommentsResponseItem = commentsList[position]
        holder.commentsItemListBinding.comments = commentsList

        holder.commentsItemListBinding.root.setOnClickListener {
            var sb = StringBuilder()
            commentsList.body.forEach{c ->
                when(c) {
                    'a', 'e', 'i', 'o', 'u' ->
                    sb.append("$c ")
                }
            }
            Log.d("vowels: ",sb.toString() +" clicked")
            val intent = Intent(mContext, VowelsActivity::class.java)
            intent.putExtra(mContext.getString(R.string.vowels), sb.toString())
            mContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return commentsList.size
    }


}