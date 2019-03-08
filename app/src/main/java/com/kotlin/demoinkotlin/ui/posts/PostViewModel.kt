package com.kotlin.demoinkotlin.ui.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demoinkotlin.Model.PostResponse

/**
 * Created by satyanarayana on 12/9/18.
 **/

class PostViewModel : ViewModel(){

    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(postResponse: PostResponse){
        postTitle.value = postResponse.title
        postBody.value = postResponse.body
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }

    fun getActivityName() : String{

        return "PhotoListActivity"
    }

}