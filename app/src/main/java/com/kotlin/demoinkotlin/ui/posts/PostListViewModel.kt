package com.kotlin.demoinkotlin.ui.posts

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View
import com.kotlin.demoinkotlin.Model.PostResponse
import com.kotlin.demoinkotlin.R
import javax.inject.Inject

/**
 * Created by satyanarayana on 12/9/18.
 **/

class PostListViewModel @Inject constructor(private val postsRepositry: PostsRepositry) : ViewModel(){

    //private lateinit var subscription: Disposable

    val errorMessage: MutableLiveData<Int> = MutableLiveData()

    val successMessage: MutableLiveData<Int> = MutableLiveData()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val postListAdapter: PostListAdapter = PostListAdapter()

    /*init {

        //isPostsLoaded.value = false
        //loadPosts(userId)

    }*/

    fun loadPosts(userId : Int) {

        postsRepositry.getPostDetails(userId)

        postsRepositry.postDetailsResponseMutableLiveData.observeForever(

                {
                    response ->
                    if (response != null) {
                        onRetrieveUsersListSuccess(response)
                    }
                }
        )

        postsRepositry.loadingVisibility.observeForever(

                {
                    showVisibility -> if (showVisibility ==0){
                    onRetrieveUsersListStart()
                }else if (showVisibility ==1){
                    onRetrieveUsersListFinish()
                }
                }
        )

        postsRepositry.errorMessage.observeForever(

                {
                    onRetrieveUsersListError()
                }
        )

    }

    /*private fun loadPosts() {

        subscription = apiInterface.getPosts(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveUsersListStart() }
                .doOnTerminate { onRetrieveUsersListFinish() }
                .subscribe(
                        { result -> onRetrieveUsersListSuccess(result) },
                        { onRetrieveUsersListError() }
                )
    }
*/
    private fun onRetrieveUsersListStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveUsersListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveUsersListSuccess(response: List<PostResponse>) {
        successMessage.value = R.string.success
        postListAdapter.updatePostsList(response)

    }

    private fun onRetrieveUsersListError() {
        errorMessage.value = R.string.error
    }

    override fun onCleared() {
        super.onCleared()

        postsRepositry.loadingVisibility.removeObserver { }
        postsRepositry.errorMessage.removeObserver { }
        postsRepositry.postDetailsResponseMutableLiveData.removeObserver {  }
    }
}