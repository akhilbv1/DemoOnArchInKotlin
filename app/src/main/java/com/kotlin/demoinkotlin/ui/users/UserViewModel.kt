package com.kotlin.demoinkotlin.ui.users

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Intent
import android.databinding.BindingAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlin.demoinkotlin.Model.UserResponse
import com.kotlin.demoinkotlin.ui.posts.PostsListActivity
import com.kotlin.demoinkotlin.utils.extension.getParentActivity

/**
 * Created by satyanarayana on 11/9/18.
 **/

class UserViewModel : ViewModel(){

    private val userName = MutableLiveData<String>()
    private val userPhoneNumber = MutableLiveData<String>()
    private val userId = MutableLiveData<Int>()

    fun bind(userResponse: UserResponse){
        userName.value = userResponse.name
        userPhoneNumber.value = userResponse.phone
        userId.value = userResponse.id
    }

    fun getUserName():MutableLiveData<String>{
        return userName
    }

    fun getUserPhoneNumber():MutableLiveData<String>{
        return userPhoneNumber
    }

    fun getUserId() : MutableLiveData<Int>{

        return userId
    }

}
