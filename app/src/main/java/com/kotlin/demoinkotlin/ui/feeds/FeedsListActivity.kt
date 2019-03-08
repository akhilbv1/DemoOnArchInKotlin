package com.kotlin.demoinkotlin.ui.feeds

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.kotlin.demoinkotlin.R
import com.kotlin.demoinkotlin.databinding.ActivityFeedListBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class FeedsListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding : ActivityFeedListBinding

    private lateinit var feedListViewModel: FeedListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_feed_list)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_list)

        // Set toolbar title

        binding.toolbar?.toolbar?.title = "Feeds"

        setSupportActionBar(binding.toolbar!!.toolbar)

        if(supportActionBar!=null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        binding.feedsList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        feedListViewModel = ViewModelProviders.of(this,viewModelFactory )[FeedListViewModel::class.java]

        binding.viewModel = feedListViewModel
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
