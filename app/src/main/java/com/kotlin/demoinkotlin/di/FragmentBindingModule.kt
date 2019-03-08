package com.kotlin.demoinkotlin.di

import com.kotlin.demoinkotlin.ui.photos.PhotosListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by satyanarayana on 17/9/18.
 **/

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun providePhotosFragment() : PhotosListFragment
}