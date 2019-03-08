package com.kotlin.demoinkotlin.Model

/**
 * Created by satyanarayana on 20/9/18.
 **/

data class Result(val status : String,val totalResults : Int,val  articles : List<FeedsReponse>)