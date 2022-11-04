package com.eldevs.githubusersmvp.ui


import com.eldevs.githubusersmvp.data.repository.UserRepository

class Presenter (
    private var view: UsersContract.UserView?,
    private val userRepository: UserRepository
): UsersContract.Presenter {

    override suspend fun getUsersList() {
        view?.showProgress()
        try {
            view?.onGetUsersList(userRepository.getUsersList())
        } catch (e: Exception) {
            view?.showErrMessage(e.message.toString())
        }
        view?.hideProgress()
    }

    override suspend fun getUserInfo(username: String) {
        view?.showProgress()
        try {
            view?.onGetUserInfo(userRepository.getUserInfo(username))
        } catch (e: Exception) {
            view?.showErrMessage(e.message.toString())
        }
        view?.hideProgress()
    }

    override fun dropView() {
        view = null
    }
}