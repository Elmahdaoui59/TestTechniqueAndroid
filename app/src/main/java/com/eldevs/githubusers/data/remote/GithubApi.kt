package com.eldevs.githubusers.data.remote

import com.eldevs.githubusers.data.model.UserInfo
import com.eldevs.githubusers.data.model.UserItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("users")
    suspend fun getUsers(): List<UserItem>

    @GET("users/{user}")
    suspend fun getUserInfo(
        @Path("user") username: String
    ): UserInfo
}