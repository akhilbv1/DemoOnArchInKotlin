package com.kotlin.demoinkotlin.ui.feeds

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kotlin.demoinkotlin.Model.FeedsReponse
import com.kotlin.demoinkotlin.Model.PostResponse

/**
 * Created by satyanarayana on 21/9/18.
 **/

class FeedViewModel : ViewModel(){

    private val feedTitle = MutableLiveData<String>()
    private val feedDescription = MutableLiveData<String>()
    private val feedAuthor = MutableLiveData<String>()
    private val feedImageUrl = MutableLiveData<String>()

    fun bind(feedsResponse: FeedsReponse){
        feedTitle.value = feedsResponse.title
        feedDescription.value = feedsResponse.description
        feedAuthor.value = feedsResponse.author
        feedImageUrl.value = feedsResponse.urlToImage
    }

    fun getFeedTitle(): MutableLiveData<String> {
        return feedTitle
    }

    fun getFeedDescription(): MutableLiveData<String> {
        return feedDescription
    }

    fun getFeedAuthor(): MutableLiveData<String> {
        return feedTitle
    }

    fun getFeedImageUrl(): MutableLiveData<String> {
        return feedImageUrl
    }

}