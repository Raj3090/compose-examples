package com.example.composelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composelist.data.MovieRepository
import com.example.composelist.data.MovieRepositoryImpl

class MoviesViewModel :ViewModel(){

    private val _movies= MutableLiveData<List<Movie>>()
    val movies:MutableLiveData<List<Movie>> = _movies

    init {
        fetchMovies()
    }

    private fun fetchMovies(){
        val moviesRepository:MovieRepository=MovieRepositoryImpl()
        val list= moviesRepository.fetchMoviesList()
        _movies.value=list
    }

}