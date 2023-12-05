package com.dicoding.storyapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dicoding.storyapp.R
import com.dicoding.storyapp.databinding.ActivityAddStoryBinding
import com.dicoding.storyapp.databinding.ActivityMainBinding
import com.dicoding.storyapp.viewmodel.StoryViewModel

class AddStoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddStoryBinding
    private lateinit var storyViewModel: StoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_story)

        storyViewModel = ViewModelProvider(this).get(StoryViewModel::class.java)

        binding.viewModel = ViewModelProvider(this).get(StoryViewModel::class.java)

        binding.lifecycleOwner = this

        storyViewModel.showAddStorySuccess.observe(this, { success ->
            if (success){
                Toast.makeText(this, "Story added successfully!", Toast,LENGTH_SHORT).show()
            }
        })

        binding.btnAddStory.setOnClickListener{
            uploadStory()
        }
    }

    private fun uploadStory() {
        val photoUrl = "url_foto_yang_diupload"
        val description = binding.edAddDescription.text.toString()

        storyViewModel.addStory(photoUrl, description)

        finish()
    }
}