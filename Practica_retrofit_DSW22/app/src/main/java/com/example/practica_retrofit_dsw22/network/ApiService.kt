package com.example.practica_retrofit_dsw22.network

import com.example.practica_retrofit_dsw22.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET(value = "")
    suspend fun getPost(): List<Post>
}