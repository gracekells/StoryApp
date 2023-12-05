package com.dicoding.storyapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.storyapp.model.Story
import com.dicoding.storyapp.repository.StoryRepository
import kotlinx.coroutines.launch

class StoryViewModel(private val storyRepository: StoryRepository) : ViewModel() {
    private val _stories = MutableLiveData<List<Story>>()
    val stories: LiveData<List<Story>> get() = _stories

    fun getStories(){
        viewModelScope.launch{
            val result = storyRepository.getStories()
            _stories.postValue(result)
        }
    }

    fun addStory(photoUrl: String, description: String){
        viewModelScope.launch{
            storyRepository.addStory(photoUrl, description)
        }
    }
}