package com.kotlin.demoinkotlin.ui.feeds

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.kotlin.demoinkotlin.Model.FeedsReponse
import com.kotlin.demoinkotlin.Model.Result
import com.kotlin.demoinkotlin.network.ApiInterface
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by satyanarayana on 21/9/18.
 **/

class FeedsDataSourceFactory(val apiInterface: ApiInterface,val compositeDisposable: CompositeDisposable)
    : DataSource.Factory<Int, FeedsReponse>() {

    val feedsDataSourceLiveData = MutableLiveData<FeedDataSource>()

    override fun create(): DataSource<Int, FeedsReponse> {
        val feedsDataSource = FeedDataSource(apiInterface = apiInterface ,compositeDisposable = compositeDisposable)
        feedsDataSourceLiveData.postValue(feedsDataSource)
        return feedsDataSource
    }
}
