package com.example.practica_retrofit_dsw22.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica_retrofit_dsw22.model.Post
import com.example.practica_retrofit_dsw22.network.RetrofitInstance
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    var posts by mutableStateOf<List<Post>>(emptyList())

    init{
        viewModelScope.launch{
            posts = RetrofitInstance.api.getPost()
        }
    }
}