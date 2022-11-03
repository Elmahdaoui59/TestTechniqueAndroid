package com.eldevs.githubusers.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelProvider
import com.eldevs.githubusers.data.model.UserInfo
import com.eldevs.githubusers.databinding.ActivityUserInfoBinding
import com.eldevs.githubusers.util.Constants.USER_TAG

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userInfo = intent.getParcelableExtra<UserInfo>(USER_TAG)
        if (userInfo != null) {
            with(binding) {
                tvLogin.text = userInfo.login
                tvName.text = userInfo.name
                tvFollowers.text = userInfo.followers.toString()
                tvRepos.text = userInfo.public_repos.toString()
                tvAccCreationDate.text = userInfo.created_at
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
            return true
        }
        return false
    }
}