package com

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ninanadia.githubuser.R

class ListGitUserAdapter(private val listGitUser: ArrayList<GitUser>) : RecyclerView.Adapter<ListGitUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, username, _, _, _, _, avatar) = listGitUser[position]
        holder.imgPhoto.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvUsername.text = username

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listGitUser[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listGitUser.size

    interface OnItemClickCallback {
        fun onItemClicked(data: GitUser)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
    }

}