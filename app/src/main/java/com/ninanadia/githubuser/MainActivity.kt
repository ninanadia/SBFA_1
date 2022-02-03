package com.ninanadia.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.DetailUserActivity
import com.GitUser
import com.ListGitUserAdapter
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvGitUser: RecyclerView
    private val list = ArrayList<GitUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGitUser = findViewById(R.id.rv_githubuser)
        rvGitUser.setHasFixedSize(true)

        list.addAll(listGitUser)
        showRecyclerList()
    }

    private val listGitUser: ArrayList<GitUser>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val dataPhoto = resources.obtainTypedArray(R.array.avatar)
            dataPhoto.recycle()
            val listGitUser = ArrayList<GitUser>()
            for (i in dataName.indices) {
                val gituser = GitUser(
                    dataName[i],
                    dataUsername[i],
                    dataLocation[i],
                    dataCompany[i],
                    dataFollowers[i],
                    dataFollowing[i],
                    dataPhoto.getResourceId(i, -1)
                )
                listGitUser.add(gituser)
            }
            return listGitUser
        }


    private fun showRecyclerList() {
        rvGitUser.layoutManager = LinearLayoutManager(this)
        val listGitUserAdapter = ListGitUserAdapter(list)
        rvGitUser.adapter = listGitUserAdapter

        listGitUserAdapter.setOnItemClickCallback(object : ListGitUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GitUser) {
                val gituser = GitUser(
                    data.name,
                    data.username,
                    data.location,
                    data.company,
                    data.following,
                    data.followers,
                    data.avatar
                )
                val detailUserActivity = Intent(this@MainActivity, DetailUserActivity::class.java)
                detailUserActivity.putExtra(DetailUserActivity.EXTRA_GITUSER, gituser)
                startActivity(detailUserActivity)
            }
        })
    }
}