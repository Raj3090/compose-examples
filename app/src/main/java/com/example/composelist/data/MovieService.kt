package com.example.composelist.data

import com.example.composelist.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("discover/movie") 
   suspend  fun getPopularMovies(
        @Query("api_key") clientId: String = BuildConfig.MOVIE_API_ACCESS_KEY
    ): Call<PopularMovieResponse>
}

