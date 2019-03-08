package com.kotlin.demoinkotlin.ui.photos

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demoinkotlin.Model.PhotosResponse

/**
 * Created by satyanarayana on 17/9/18.
 **/

class PhotosViewModel:ViewModel(){

    private val photoTitle = MutableLiveData<String>()
    private val photoThumbnailUrl = MutableLiveData<String>()
    private val photoUrl = MutableLiveData<String>()

    fun bind(photoResponse: PhotosResponse){
        photoTitle.value = photoResponse.title
        photoThumbnailUrl.value = photoResponse.thumbnailUrl
        photoUrl.value = photoResponse.url
    }

    fun getPhotoTitle(): MutableLiveData<String> {
        return photoTitle
    }

    fun getPhotoThumbnailUrl(): MutableLiveData<String> {
        return photoThumbnailUrl
    }

    fun getPhotoUrl() : MutableLiveData<String> {

        return photoUrl
    }

}
