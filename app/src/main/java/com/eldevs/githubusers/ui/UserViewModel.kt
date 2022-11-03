package com.eldevs.githubusers.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eldevs.githubusers.data.model.UserItem
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


    fun getUserList() {
        viewModelScope.launch {
            try {
                _users.value =_users.value?.copy(
                    users = userRepository.getUsersList()
                )
            } catch (e: Exception) {
                _users.value = _users.value?.copy(
                    error = e.message.toString()
                )
            }
        }
    }
    fun dismissError() {
        _users.value = _users.value?.copy(
            error = null
        )
    }

}