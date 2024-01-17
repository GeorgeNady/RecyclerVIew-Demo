package dev.george.resview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import dev.george.resview.adapter.ClickEvents
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
        postsRecyclerViewClickListener()
    }

    private fun postsRecyclerViewClickListener() {
        postsAdapter.setOnItemClickListener { clickEvents: ClickEvents, post: Post ->
            when(clickEvents) {
                ClickEvents.LIKE -> {
                    Log.d(TAG, "postsRecyclerViewClickListener: clickEvents: ${clickEvents.name} post $post")
                    // do on like click listener logic here
                }
                ClickEvents.COMMENT -> {
                    Log.d(TAG, "postsRecyclerViewClickListener: clickEvents: ${clickEvents.name} post $post")
                    // do on comment click listener logic here
                }
                ClickEvents.SHARE -> {
                    Log.d(TAG, "postsRecyclerViewClickListener: clickEvents: ${clickEvents.name} post $post")
                    // do on share click listener logic here
                }
            }
        }
    }

    private companion object {
        private const val TAG = "MainActivity"
    }

}

