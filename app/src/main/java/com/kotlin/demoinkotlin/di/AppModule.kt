package com.kotlin.demoinkotlin.di

import dagger.Module

/**
 * Created by satyanarayana on 11/9/18.
 **/

@Module(includes = [(ViewModelModule::class)])
class AppModule{

   /* @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }*/


   /*@Binds
    internal abstract fun provideContext(application: Application): Context*/
   /* @Provides
    @Singleton
    internal abstract fun provideContext(application: Application): Context*//*

    @Binds
    internal fun providePostApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }*/

}
