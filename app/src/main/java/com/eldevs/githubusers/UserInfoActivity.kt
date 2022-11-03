package com.eldevs.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eldevs.githubusers.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}