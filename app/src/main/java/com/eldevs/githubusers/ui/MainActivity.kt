package com.eldevs.githubusers.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.eldevs.githubusers.data.model.UserItem
import com.eldevs.githubusers.databinding.ActivityMainBinding
import com.eldevs.githubusers.util.Constants.USER_TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userAdapter = UserAdapter { user ->
            showUserInfo(user)
        }
        setUpRecyclerView()
        observeUsersList()
        refreshUsersList()
        binding.swipeContainer.setOnRefreshListener {
            refreshUsersList()
        }
    }

    private fun showUserInfo(user: UserItem) {
        binding.progressBar.visibility = View.VISIBLE
        val intent = Intent(this, UserInfoActivity::class.java)
        lifecycleScope.launch {
            userViewModel.getUserInfo(user.login)
            userViewModel.users.value?.userInfo?.let {
                binding.progressBar.visibility = View.GONE
                intent.putExtra(USER_TAG, it)
                startActivity(intent)
            }
            userViewModel.dismissUserInfo()
        }
    }

    private fun refreshUsersList() {
        userViewModel.getUsersList()
        binding.swipeContainer.isRefreshing = false
    }

    private fun setUpRecyclerView() {
        binding.usersRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeUsersList() {
        userViewModel.users.observe(this) { state ->
            if (state.users.isNotEmpty()) {
                userAdapter.submitList(state.users)
                userAdapter.notifyDataSetChanged()
                binding.tvNoData.visibility = View.GONE
            } else {
                binding.tvNoData.visibility = View.VISIBLE
            }
            state.error?.let {
                Toast.makeText(this, "Oops, $it, Try again", Toast.LENGTH_LONG).show()
                userViewModel.dismissError()
                binding.progressBar.visibility = View.GONE
            }
        }
    }

}