package com.dicoding.storyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.dicoding.storyapp.databinding.ItemStoryBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.storyapp.model.Story

class StoryAdapter : ListAdapter<Story, StoryAdapter.StoryViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder{
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int){
        val currentStory = getItem(position)
        holder.bind(currentStory)
    }

    inner class StoryViewHolder(private val binding: ItemStoryBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun bind(story: Story){
                    binding.story = story
                    binding.executePendingBindings()
                }
            }

    private class DiffCallback : DiffUtil.ItemCallback<Story>(){
        override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
            return  oldItem == newItem
        }
    }
}