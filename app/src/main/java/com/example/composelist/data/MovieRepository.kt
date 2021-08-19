package com.example.composelist.data

import com.example.composelist.Movie

interface MovieRepository {

    suspend fun fetchMoviesList():List<Movie>
}