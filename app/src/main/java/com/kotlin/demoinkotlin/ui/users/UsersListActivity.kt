package com.kotlin.demoinkotlin.ui.users

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.kotlin.demoinkotlin.R
import com.kotlin.demoinkotlin.databinding.ActivityUsersListBinding
import com.kotlin.demoinkotlin.ui.posts.PostsListActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by satyanarayana on 11/9/18.
 **/

class UsersListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: ActivityUsersListBinding

    private lateinit var listViewModel: UsersListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_users_list)

        // Set toolbar title

        binding.toolbar?.toolbar?.title = "Users"

        setSupportActionBar(binding.toolbar!!.toolbar)

        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        listViewModel = ViewModelProviders.of(this,viewModelFactory )[UsersListViewModel::class.java]

        listViewModel.errorMessage.observe(this, Observer {

            error -> if (error!=null){ showError() } })

        listViewModel.successMessage.observe(this, Observer {

            success -> if (success!=null){ showSuccess() } })

        binding.viewModel = listViewModel

    }

    private fun showSuccess() {

        Toast.makeText(this@UsersListActivity,"Success",Toast.LENGTH_SHORT).show()
    }

    private fun showError() {

        Toast.makeText(this@UsersListActivity,"Error",Toast.LENGTH_SHORT).show()
    }

}


