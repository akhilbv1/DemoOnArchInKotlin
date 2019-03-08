package com.kotlin.demoinkotlin.di

import com.kotlin.demoinkotlin.ui.feeds.FeedsListActivity
import com.kotlin.demoinkotlin.ui.photos.PhotosListActivity
import com.kotlin.demoinkotlin.ui.posts.PostsListActivity
import com.kotlin.demoinkotlin.ui.users.UsersListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by satyanarayana on 11/9/18.
 **/

@Module
abstract class ActivitiesBindingModule{

    @ContributesAndroidInjector
    abstract fun usersListActivity():UsersListActivity

    @ContributesAndroidInjector
    abstract fun postsListActivity():PostsListActivity

    @ContributesAndroidInjector
    abstract fun photoListActivity():PhotosListActivity

    @ContributesAndroidInjector
    abstract fun feedslistActivity(): FeedsListActivity
}
