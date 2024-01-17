package dev.george.resview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.george.resview.R

class StoriesAdapter(private val data: List<String>): RecyclerView.Adapter<StoriesAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view)


    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.story_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]

        val image = holder.view.findViewById<ImageView>(R.id.ivStoryImage)
        val caption = holder.view.findViewById<TextView>(R.id.tvStoryCaption)

        image.setImageResource(R.drawable.ic_launcher_background)
        caption.text = currentItem
    }

}