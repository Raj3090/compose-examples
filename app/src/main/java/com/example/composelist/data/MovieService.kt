package com.example.composelist.data

import com.example.composelist.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("discover/movie")
     fun getPopularMovies(
        @Query("api_key") clientId: String = "5011b1832bf0a2bb8ca5285e33943fad"
    ): Call<PopularMovieResponse>
}