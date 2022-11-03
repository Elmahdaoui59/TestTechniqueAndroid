package com.eldevs.githubusers.ui

import com.eldevs.githubusers.data.model.UserInfo
import com.eldevs.githubusers.data.model.UserItem

data class UsersState(
    val users: List<UserItem> = emptyList(),
    val error: String? = null,
    val userInfo: UserInfo? = null
)
