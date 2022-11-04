package com.eldevs.githubusersmvp.ui

import com.eldevs.githubusersmvp.data.model.UserInfo
import com.eldevs.githubusersmvp.data.model.UserItem

interface UsersContract {

    interface UserView {
        fun onGetUsersList(list: List<UserItem>)
        fun onGetUserInfo(userInfo: UserInfo)
        fun showProgress()
        fun hideProgress()
        fun showErrMessage(errMsg: String)
    }

    interface Presenter {
        suspend fun getUsersList()
        suspend fun getUserInfo(username: String)
        fun dropView()
    }
}