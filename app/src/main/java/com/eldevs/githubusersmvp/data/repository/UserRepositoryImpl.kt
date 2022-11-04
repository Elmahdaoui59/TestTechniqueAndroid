package com.eldevs.githubusersmvp.data.repository

import com.eldevs.githubusersmvp.data.model.UserInfo
import com.eldevs.githubusersmvp.data.model.UserItem
import com.eldevs.githubusersmvp.data.remote.GithubApi
import com.eldevs.githubusersmvp.data.repository.UserRepository

class UserRepositoryImpl(
    private val api: GithubApi
) : UserRepository {

    override suspend fun getUsersList(): List<UserItem> {
        return api.getUsers()
    }

    override suspend fun getUserInfo(username: String): UserInfo {
        return api.getUserInfo(username)
    }
}