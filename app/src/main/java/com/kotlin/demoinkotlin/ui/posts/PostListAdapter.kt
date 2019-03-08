package com.kotlin.demoinkotlin.ui.posts

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.demoinkotlin.Model.PostResponse
import com.kotlin.demoinkotlin.R
import com.kotlin.demoinkotlin.databinding.PostsListBinding

/**
 * Created by satyanarayana on 12/9/18.
 **/

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    private lateinit var postsList:List<PostResponse>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListAdapter.ViewHolder {

        val binding : PostsListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.posts_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostListAdapter.ViewHolder, position: Int) {
        holder.bind(postsList[position])
    }

    override fun getItemCount(): Int {
        return if(::postsList.isInitialized) postsList.size else 0
    }

    fun updatePostsList(postsList: List<PostResponse>){
        this.postsList = postsList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: PostsListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(postResponse: PostResponse) {

            val viewModel = PostViewModel()

            viewModel.bind(postResponse)
            binding.viewModel = viewModel
        }
    }
}