package com.rivaldo.githubuserapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rivaldo.githubuserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.setHasFixedSize(true)
        list.addAll(getListUsers())
        showRecyclerList()
    }

    private fun getListUsers(): ArrayList<User> {
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        val dataUserName = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)

        val listUser = ArrayList<User>()
        listUser.clear()

        for (position in dataName.indices) {
            val user = User (
                    dataPhoto.getResourceId(position, -1),
                    dataUserName[position],
                    dataName[position],
                    dataLocation[position],
                    dataCompany[position],
                    dataRepository[position],
                    dataFollowers[position],
                    dataFollowing[position]
                    )
            listUser.add(user)
        }
        dataPhoto.recycle()
        return listUser
    }

    private fun showRecyclerList() {
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        binding.rvUsers.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object: ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(user: User) {
                showSelectedUser(user)
            }
        })
    }

    private fun showSelectedUser(user: User) {
        val moveDetail = Intent(this@MainActivity, DetailUserActivity::class.java)
        moveDetail.putExtra(DetailUserActivity.EXTRA_USER, user)
        startActivity(moveDetail)
    }
}