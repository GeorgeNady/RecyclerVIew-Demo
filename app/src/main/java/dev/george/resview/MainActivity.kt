package dev.george.resview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import dev.george.resview.adapter.PostsAdapter
import dev.george.resview.adapter.StoriesAdapter
import dev.george.resview.model.Post
import dev.george.resview.repo.posts
import dev.george.resview.repo.stories

// B: Controller
class MainActivity : AppCompatActivity() {

    private lateinit var rvStory: RecyclerView
    private lateinit var storiesAdapter: StoriesAdapter

    private lateinit var rvPosts: RecyclerView
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvStory = findViewById(R.id.rvStories)
        rvPosts = findViewById(R.id.rvPosts)

        setupStoriesRecyclerView()
        setupPostsRecyclerView()
    }

    private fun setupStoriesRecyclerView() {
        storiesAdapter = StoriesAdapter(stories)
        rvStory.adapter = storiesAdapter
    }

    private fun setupPostsRecyclerView() {
        postsAdapter = PostsAdapter(posts)
        rvPosts.adapter = postsAdapter
    }

}

