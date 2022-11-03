package com.eldevs.githubusers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.eldevs.githubusers.R
import com.eldevs.githubusers.data.model.UserItem
import com.eldevs.githubusers.databinding.ActivityMainBinding
import com.eldevs.githubusers.databinding.ItemUserBinding
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
        userAdapter = UserAdapter {}
        setUpRecyclerView()

        userViewModel.users.observe(this) {
            userAdapter.submitList(it)
            userAdapter.notifyDataSetChanged()

        }
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

}