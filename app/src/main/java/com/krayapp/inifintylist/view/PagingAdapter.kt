package com.krayapp.inifintylist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.krayapp.inifintylist.databinding.PostTemplateBinding
import com.krayapp.inifintylist.model.RedditPost

class PagingAdapter : PagingDataAdapter<RedditPost, PostsViewHolder>(HotPostDiffUtil) {
    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder =
        PostsViewHolder(
            PostTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
}

class PostsViewHolder(private val binding: PostTemplateBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(post: RedditPost) {
        with(binding) {
            descriptionView.text = post.description
            awardText.text = post.award_count.toString()
            commentText.text = post.comment_count.toString()
        }
    }
}

object HotPostDiffUtil : DiffUtil.ItemCallback<RedditPost>() {
    override fun areItemsTheSame(oldItem: RedditPost, newItem: RedditPost) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: RedditPost, newItem: RedditPost) =
        (oldItem.description == newItem.description && oldItem.comment_count == newItem.comment_count)
}