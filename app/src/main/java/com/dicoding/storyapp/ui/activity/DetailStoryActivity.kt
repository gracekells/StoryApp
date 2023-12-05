package com.dicoding.storyapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.storyapp.R
import com.dicoding.storyapp.databinding.ActivityDetailStoryBinding
import com.dicoding.storyapp.viewmodel.StoryViewModel
import com.dicoding.storyapp.model.Story

class DetailStoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val story = intent.getParcelableArrayExtra<Story>("EXTRA_STORY")

        if (story != null){
            binding.tvDetailName.text = story.userName
            binding.ivDetailPhoto.setImageResource(story.photoUrl)
            binding.tvDetailDescription.text = story.description
        }
    }
}