package com.eldevs.githubusersmvp.data.remote

import com.eldevs.githubusersmvp.data.model.UserInfo
import com.eldevs.githubusersmvp.data.model.UserItem
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("users")
    suspend fun getUsers(): List<UserItem>

    @GET("users/{user}")
    suspend fun getUserInfo(
        @Path("user") username: String
    ): UserInfo
}