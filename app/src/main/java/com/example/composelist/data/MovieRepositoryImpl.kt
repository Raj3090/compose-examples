package com.example.composelist.data

import com.example.composelist.Movie

class MovieRepositoryImpl :MovieRepository{

    override fun fetchMoviesList(): List<Movie> {
        return listOf(Movie("SpiderMan","https://picsum.photos/200"),
            Movie("Hulk","https://picsum.photos/200")
        )
    }

}