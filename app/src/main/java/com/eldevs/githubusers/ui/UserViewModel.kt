package com.eldevs.githubusers.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eldevs.githubusers.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _users: MutableLiveData<UsersState> by lazy {
        MutableLiveData<UsersState>(UsersState())
    }
    val users: LiveData<UsersState>
        get() = _users


    fun getUsersList() {
        viewModelScope.launch {
            try {
                _users.value = users.value?.copy(
                    users = userRepository.getUsersList()
                )
            } catch (e: Exception) {
                _users.value = users.value?.copy(
                    error = e.message.toString()
                )
            }
        }
    }

    suspend fun getUserInfo(username: String) {
        try {
            _users.value = users.value?.copy(
                userInfo = userRepository.getUserInfo(username)
            )
        } catch (e: Exception) {
            _users.value = users.value?.copy(
                error = e.message.toString()
            )
        }
    }

    fun dismissUserInfo() {
        _users.value = users.value?.copy(
            userInfo = null
        )
    }

    fun dismissError() {
        _users.value = users.value?.copy(
            error = null
        )
    }

}