package com.kotlin.demoinkotlin.ui.users

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.view.View
import javax.inject.Inject
import com.kotlin.demoinkotlin.Model.UserResponse
import com.kotlin.demoinkotlin.R

/**
 * Created by satyanarayana on 11/9/18.
 **/

class UsersListViewModel @Inject constructor(/*private val apiInterface: ApiInterface*//*,*/ usersRepositry: UsersRepositry):ViewModel(){

    //private lateinit var subscription: Disposable

    val errorMessage:MutableLiveData<Int> = MutableLiveData()

    val successMessage:MutableLiveData<Int> = MutableLiveData()

    //private var mApiResponseMediatorLiveData: MediatorLiveData<List<UserResponse>> = MediatorLiveData<List<UserResponse>>()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val userListAdapter: UsersListAdapter = UsersListAdapter()

    init{
       //loadUsers()

        usersRepositry.getUserDetails()

        usersRepositry.userDetailsResponseMutableLiveData.observeForever(

                Observer {
                    response ->
                    if (response != null) {
                        onRetrieveUsersListSuccess(response)
                    }
                }
        )

        usersRepositry.loadingVisibility.observeForever(

                Observer {

                    showVisibility -> if (showVisibility ==0){
                    onRetrieveUsersListStart()
                }else if (showVisibility ==1){
                    onRetrieveUsersListFinish()
                }
                }
        )

        usersRepositry.errorMessage.observeForever(

                Observer {

                    onRetrieveUsersListError()

                }
        )

    }


   /* private fun loadUsers() {

        subscription = apiInterface.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveUsersListStart() }
                .doOnTerminate { onRetrieveUsersListFinish() }
                .subscribe(
                        { result -> onRetrieveUsersListSuccess(result) },
                        { onRetrieveUsersListError() }
                )
    }*/

    private fun onRetrieveUsersListStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveUsersListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveUsersListSuccess(response: List<UserResponse>) {
        successMessage.value = R.string.success
        userListAdapter.updateUsersList(response)
    }

    private fun onRetrieveUsersListError() {

        errorMessage.value = R.string.error
    }

}
