package com.eldevs.githubusersmvp.data.remote

import com.eldevs.githubusersmvp.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitService: GithubApi by lazy {
        retrofit.create(GithubApi::class.java)
    }
}