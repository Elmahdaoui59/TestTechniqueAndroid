package com.eldevs.githubusers.data.repository

import com.eldevs.githubusers.data.model.UserItem
import com.eldevs.githubusers.data.remote.GithubApi

class UserRepositoryImpl(private val api: GithubApi): UserRepository {

    override suspend fun getUsersList(): List<UserItem> {
        return api.getUsers()
    }
}