package com.eldevs.githubusers.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.eldevs.githubusers.R
import com.eldevs.githubusers.UserInfoActivity
import com.eldevs.githubusers.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userViewModel: UserViewModel
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userAdapter = UserAdapter {
        }
        setUpRecyclerView()
        observeData()
        refreshData()
        binding.swipeContainer.setOnRefreshListener {
            refreshData()
        }
    }

    private fun refreshData() {
        userViewModel.getUserList()
        binding.swipeContainer.isRefreshing = false
    }

    private fun setUpRecyclerView() {
        binding.usersRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeData() {
        userViewModel.users.observe(this) { state ->
            if (state.users.isNotEmpty()) {
                userAdapter.submitList(state.users)
                userAdapter.notifyDataSetChanged()
            }
            state.error?.let {
                Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
                userViewModel.dismissError()
            }
        }
    }

}