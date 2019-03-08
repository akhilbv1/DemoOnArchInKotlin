package com.kotlin.demoinkotlin.ui.feeds

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.demoinkotlin.Model.FeedsReponse
import com.kotlin.demoinkotlin.R
import com.kotlin.demoinkotlin.databinding.FeedsListBinding
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import com.kotlin.demoinkotlin.Model.Result


/**
 * Created by satyanarayana on 21/9/18.
 **/

class FeedListAdapter : PagedListAdapter<FeedsReponse, FeedListAdapter.ViewHolder>(feedsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : FeedsListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.feeds_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val result : FeedsReponse = getItem(position)!!

        holder.bind(result)
    }


    class ViewHolder(private val binding: FeedsListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(feedsReponse: FeedsReponse){

            val viewModel = FeedViewModel()
            viewModel.bind(feedsReponse)
            binding.viewModel = viewModel
        }
    }

    companion object {
        val feedsDiffCallback = object : DiffUtil.ItemCallback<FeedsReponse>() {
            override fun areItemsTheSame(oldItem: FeedsReponse, newItem: FeedsReponse): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: FeedsReponse, newItem: FeedsReponse): Boolean {
                return oldItem == newItem
            }
        }
    }

}
