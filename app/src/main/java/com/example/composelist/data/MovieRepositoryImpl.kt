package com.example.composelist.data

import com.example.composelist.Movie

class MovieRepositoryImpl :MovieRepository{

    override suspend fun fetchMoviesList(): List<Movie> {

//       val response=MovieClient.getApiClient().create(MovieService::class.java).getPopularMovies().execute()

        return listOf(Movie("SpiderMan","https://picsum.photos/200"),
            Movie("Hulk","https://picsum.photos/200")
        )
    }

}