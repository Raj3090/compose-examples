package com.example.composelist.data

import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET("movies")
    fun fetchAllPosts(): Call<List<String>>
}