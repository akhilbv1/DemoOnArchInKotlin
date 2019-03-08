package com.kotlin.demoinkotlin.ui.photos

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.demoinkotlin.Model.PhotosResponse
import com.kotlin.demoinkotlin.R
import com.kotlin.demoinkotlin.databinding.PhotosListBinding

/**
 * Created by satyanarayana on 17/9/18.
 **/

class PhotosListAdapter : RecyclerView.Adapter<PhotosListAdapter.ViewHolder>() {

    private lateinit var photosList:List<PhotosResponse>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosListAdapter.ViewHolder {

        val binding : PhotosListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.photos_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosListAdapter.ViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    override fun getItemCount(): Int {
        return if(::photosList.isInitialized) photosList.size else 0
    }

    fun updatePhotosList(photosList: List<PhotosResponse>){
        this.photosList = photosList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: PhotosListBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(photosResponse: PhotosResponse) {

            val viewModel = PhotosViewModel()

            viewModel.bind(photosResponse)
            binding.viewModel = viewModel
        }
    }
}