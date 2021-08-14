package com.example.composelist.data

import com.example.composelist.Movie

interface MovieRepository {

    fun fetchMoviesList():List<Movie>
}