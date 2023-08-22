package com.lock.tweetscompose.api

import com.lock.tweetscompose.models.TweetsListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {

    /**
     * For Dynamic Header we use Header annotation and Headers for static header
     */
    @GET("/v3/b/64de7344b89b1e2299d23c49?meta=false")
    suspend fun getTweetItems(@Header("X-JSON-Path") category:String): Response<List<TweetsListItem>>

    @GET("/v3/b/64de7344b89b1e2299d23c49?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories():Response<List<String>>
}