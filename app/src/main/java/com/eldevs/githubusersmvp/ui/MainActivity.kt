package com.eldevs.githubusersmvp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.eldevs.githubusersmvp.data.model.UserInfo
import com.eldevs.githubusersmvp.data.model.UserItem
import com.eldevs.githubusersmvp.data.remote.ApiClient
import com.eldevs.githubusersmvp.data.repository.UserRepositoryImpl
import com.eldevs.githubusersmvp.databinding.ActivityMainBinding
import com.eldevs.githubusersmvp.util.Constants.USER_TAG
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity(), UsersContract.UserView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()

        presenter = Presenter(
            view = this,
            userRepository = UserRepositoryImpl(ApiClient.retrofitService)
        )
        refreshUsersList()

        binding.swipeContainer.setOnRefreshListener {
            refreshUsersList()
        }

    }

    private fun refreshUsersList() {
        lifecycleScope.launch {
            presenter.getUsersList()
        }
    }

    override fun showErrMessage(errMsg: String) {
        Toast.makeText(
            this@MainActivity, "Oops, ${errMsg}, Try again",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onGetUsersList(list: List<UserItem>) {
        if (list.isNotEmpty()) {
            userAdapter.submitList(list)
        }
    }

    override fun onGetUserInfo(userInfo: UserInfo) {
        val intent = Intent(this, UserInfoActivity::class.java)
        intent.putExtra(USER_TAG, userInfo)
        startActivity(intent)
    }

    override fun showProgress() {
        binding.swipeContainer.isRefreshing = true
    }

    override fun hideProgress() {
        binding.swipeContainer.isRefreshing = false
    }

    private fun setUpRecyclerView() {
        userAdapter = UserAdapter {
            lifecycleScope.launch {
                presenter.getUserInfo(it.login)
            }
        }
        binding.usersRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }
}