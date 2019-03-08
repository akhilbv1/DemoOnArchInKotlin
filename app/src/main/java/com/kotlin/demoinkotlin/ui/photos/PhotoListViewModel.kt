package com.kotlin.demoinkotlin.ui.photos

import android.arch.lifecycle.*
import android.arch.lifecycle.Observer
import android.view.View
import com.kotlin.demoinkotlin.Model.PhotosResponse
import com.kotlin.demoinkotlin.R
import javax.inject.Inject

/**
 * Created by satyanarayana on 12/9/18.
 **/

class PhotoListViewModel @Inject constructor(val photosRepositry: PhotosRepositry) : ViewModel(){

    val errorMessage: MutableLiveData<Int> = MutableLiveData()

    val successMessage: MutableLiveData<Int> = MutableLiveData()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val photoListAdapter: PhotosListAdapter = PhotosListAdapter()

    fun getPhotos(){

        photosRepositry.getPhotoDetails()

        photosRepositry.photosResponseMutableLivaDeata.observeForever(

                Observer {
                    response ->
                    if (response != null) {
                        onRetrieveUsersListSuccess(response)
                    }
                }
        )

        photosRepositry.loadingVisibility.observeForever(

                Observer {

                    showVisibility -> if (showVisibility ==0){
                    onRetrieveUsersListStart()
                }else if (showVisibility ==1){
                    onRetrieveUsersListFinish()
                }
                }
        )

        photosRepositry.errorMessage.observeForever(

                Observer {

                    onRetrieveUsersListError()

                }
        )

    }

    private fun onRetrieveUsersListStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveUsersListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveUsersListSuccess(response: List<PhotosResponse>) {
        successMessage.value = R.string.success
        photoListAdapter.updatePhotosList(response)
    }

    private fun onRetrieveUsersListError() {

        errorMessage.value = R.string.error
    }

    override fun onCleared() {
        super.onCleared()
    }
}
