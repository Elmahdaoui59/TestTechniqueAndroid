package com.eldevs.githubusers.data.repository

import com.eldevs.githubusers.data.model.UserItem

class UserRepositoryImpl: UserRepository {
    override suspend fun getUsersList(): List<UserItem> {
        return listOf(
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url"),
            UserItem(id = 1, login = "login", avatar_url = "url")
        )
    }
}