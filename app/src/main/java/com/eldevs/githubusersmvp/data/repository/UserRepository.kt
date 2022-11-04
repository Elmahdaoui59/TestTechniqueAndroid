package com.eldevs.githubusersmvp.data.repository

import com.eldevs.githubusersmvp.data.model.UserInfo
import com.eldevs.githubusersmvp.data.model.UserItem

interface UserRepository {
    suspend fun getUsersList(): List<UserItem>
    suspend fun getUserInfo(username: String): UserInfo
}