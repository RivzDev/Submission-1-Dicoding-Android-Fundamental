package com.rivaldo.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rivaldo.githubuserapp.databinding.ActivityDetailUserBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        binding.imgItemPhoto.setImageResource(user.photo)
        binding.tvUsername.text = user.username
        supportActionBar?.title = user.name
        binding.tvName.text = user.name
        binding.tvLocation.text = user.location
        binding.tvCompany.text = user.company
        binding.tvRepository.text = user.repository
        binding.tvFollowers.text = user.followers
        binding.tvFollowing.text = user.following
    }
}