package com.eldevs.githubusers.data.repository

import com.eldevs.githubusers.data.model.UserInfo
import com.eldevs.githubusers.data.model.UserItem

interface UserRepository {
    suspend fun getUsersList(): List<UserItem>
    suspend fun getUserInfo(username: String): UserInfo
}