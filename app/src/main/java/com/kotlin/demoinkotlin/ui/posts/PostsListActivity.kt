package com.kotlin.demoinkotlin.ui.posts

import android.arch.lifecycle.*
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.kotlin.demoinkotlin.R
import com.kotlin.demoinkotlin.databinding.ActivityPostsListBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class PostsListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding : ActivityPostsListBinding

    private lateinit var postListViewModel: PostListViewModel

    private var userId: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_posts_list)

        userId = intent.getIntExtra("USER_ID",1)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_posts_list)

        // Set toolbar title

        binding.toolbar?.toolbar?.title = "Posts"

        setSupportActionBar(binding.toolbar!!.toolbar)

        if(supportActionBar!=null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        postListViewModel = ViewModelProviders.of(this,viewModelFactory )[PostListViewModel::class.java]

        loadPosts()

        binding.viewModel = postListViewModel

    }

    private fun loadPosts() {

        postListViewModel.loadPosts(userId)

        postListViewModel.errorMessage.observe(this, Observer {

            error -> if (error==R.string.error){ showError() } })

        postListViewModel.successMessage.observe(this, Observer {

            success -> if (success==R.string.success){ showSuccess() } })

    }

    private fun showSuccess() {

        Toast.makeText(this@PostsListActivity,"Success", Toast.LENGTH_SHORT).show()
    }

    private fun showError() {

        Toast.makeText(this@PostsListActivity,"Error", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == android.R.id.home){
            finish()
            return true
        }else{
            return super.onOptionsItemSelected(item)
        }
    }

}
