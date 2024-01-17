package dev.george.resview.adapter

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

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////// adapter custom view holder
    ////////////////////////////////////////////////////////////////////////////////////////////////
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    ////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////// adapter main implemented members
    ////////////////////////////////////////////////////////////////////////////////////////////////
    override fun getItemCount() = posts.size

    // create single view on each iteration
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = posts[position]

        // adapter item's views => initialization
        val ivAvatar = holder.itemView.findViewById<ImageView>(R.id.ivAvatar)
        val tvUserName = holder.itemView.findViewById<TextView>(R.id.tvUserName)
        val tvTimeAgo = holder.itemView.findViewById<TextView>(R.id.tvTimeAgo)
        val tvPostContent = holder.itemView.findViewById<TextView>(R.id.tvPostContent)
        val btnLike = holder.itemView.findViewById<TextView>(R.id.btnLike)
        val btnComment = holder.itemView.findViewById<TextView>(R.id.btnComment)
        val btnShare = holder.itemView.findViewById<TextView>(R.id.btnShare)

        // adapter item's views => set values
        currentItem.avatar?.let { ivAvatar.setImageResource(it) }
        tvUserName.text = currentItem.username
        tvTimeAgo.text = holder.itemView.context.getString(R.string.minute_ago, getRandomTimeAgo().toString())
        tvPostContent.text = currentItem.content

        // adapter item's views => click listeners
        btnLike.setOnClickListener {
            onItemClickListener?.let { it(ClickEvents.LIKE, currentItem) }
        }

        btnComment.setOnClickListener {
            onItemClickListener?.let { it(ClickEvents.COMMENT, currentItem) }
        }

        btnShare.setOnClickListener {
            onItemClickListener?.let { it(ClickEvents.SHARE, currentItem) }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////// click listener
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private var onItemClickListener: ((ClickEvents, Post) -> Unit)? = null

    fun setOnItemClickListener(listener: (ClickEvents, Post) -> Unit) {
        onItemClickListener = listener
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////// helpers
    ////////////////////////////////////////////////////////////////////////////////////////////////
    private fun getRandomTimeAgo() = Random.nextInt(1, 61)

}

enum class ClickEvents {
    LIKE,
    COMMENT,
    SHARE
}