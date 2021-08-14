package com.example.composelist

data class Movie(val name:String,val posterUrl:String){


    companion object{
        fun fetchMoviesList():List<Movie>{
            return listOf(Movie("SpiderMan","https://picsum.photos/200"),
                Movie("Hulk","https://picsum.photos/200")
            )
        }
    }

}

