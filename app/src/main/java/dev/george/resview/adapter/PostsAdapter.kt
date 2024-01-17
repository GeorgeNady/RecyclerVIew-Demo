package dev.george.resview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.george.resview.R
import dev.george.resview.model.Post
import kotlin.random.Random

class PostsAdapter(private val posts: List<Post>): RecyclerView.Adapter<PostsAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun getItemCount() = posts.size

    // create single view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = posts[position]

        val ivAvatar = holder.itemView.findViewById<ImageView>(R.id.ivAvatar)
        val tvUserName = holder.itemView.findViewById<TextView>(R.id.tvUserName)
        val tvTimeAgo = holder.itemView.findViewById<TextView>(R.id.tvTimeAgo)
        val tvPostContent = holder.itemView.findViewById<TextView>(R.id.tvPostContent)
        val btnLike = holder.itemView.findViewById<TextView>(R.id.btnLike)
        val btnComment = holder.itemView.findViewById<TextView>(R.id.btnComment)
        val btnShare = holder.itemView.findViewById<TextView>(R.id.btnShare)


        if (currentItem.avatar != null) {
            ivAvatar.setImageResource(currentItem.avatar)
        }

        tvUserName.text = currentItem.username

        val randomTimeAgo = Random.nextInt(1, 61)
        tvTimeAgo.text = "$randomTimeAgo minute ago"

        tvPostContent.text = currentItem.content



        btnLike.setOnClickListener {
            Log.d("PostAdapter", "position $position")
            Log.d("PostAdapter", "currentItem $currentItem")
        }

        btnComment.setOnClickListener {
            Log.d("PostAdapter", "btn Comment clicked")
        }

        btnShare.setOnClickListener {
            Log.d("PostAdapter", "btn Share clicked")
        }
    }

}