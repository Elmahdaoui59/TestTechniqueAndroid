package com.eldevs.githubusers.data.remote

import com.eldevs.githubusers.data.model.UserItem
import retrofit2.http.GET

interface GithubApi {

    @GET("users")
    suspend fun getUsers(): List<UserItem>
}