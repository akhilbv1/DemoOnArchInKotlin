package com.kotlin.demoinkotlin.network

import com.kotlin.demoinkotlin.Model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by satyanarayana on 11/9/18.
 **/

interface ApiInterface {

    @GET("/users")
    fun getUsers(): Observable<List<UserResponse>>

    @GET("/posts")
    fun getPosts(@Query("userId") userId : Int ): Observable<List<PostResponse>>

    @GET("/photos")
    fun getPhotos() : Observable<List<PhotosResponse>>

    @GET("/v2/everything?q=movies&apiKey=079dac74a5f94ebdb990ecf61c8854b7")
    fun getFeeds(@Query("page") page: Int): Observable<Result>

}