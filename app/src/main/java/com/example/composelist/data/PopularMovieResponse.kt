package com.example.composelist.data

import com.example.composelist.Movie

data class PopularMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)