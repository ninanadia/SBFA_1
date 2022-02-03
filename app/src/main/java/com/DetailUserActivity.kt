package com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.ninanadia.githubuser.R

class DetailUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val actionBar = getSupportActionBar()
        actionBar!!.title = "Detail User"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        showUserDetail()
    }

    private fun showUserDetail() {
        val tvImageReceived: ImageView = findViewById(R.id.img_user_photo)
        val tvNameReceived: TextView = findViewById(R.id.tv_name_received)
        val tvUserReceived: TextView = findViewById(R.id.tv_username_received)
        val tvLocationReceived: TextView = findViewById(R.id.tv_location_received)
        val tvCompanyReceived: TextView = findViewById(R.id.tv_company_received)
        val tvFollowersReceived: TextView = findViewById(R.id.tv_followers_received)
        val tvFollowingReceived: TextView = findViewById(R.id.tv_following_received)

        val gituser = intent.getParcelableExtra<GitUser>(EXTRA_GITUSER) as GitUser

        tvImageReceived.setImageResource(gituser.avatar)
        tvNameReceived.text = "${gituser.name}"
        tvUserReceived.text = "${gituser.username}"
        tvLocationReceived.text = "${gituser.location}"
        tvCompanyReceived.text = "${gituser.company}"
        tvFollowersReceived.text = "${gituser.followers} Followers"
        tvFollowingReceived.text = "${gituser.following} Following"
    }

    companion object {
        const val EXTRA_GITUSER = "extra_gituser"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}