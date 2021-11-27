package com.example.razmovies.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.razmovies.data.ResultsItem
import com.example.razmovies.network.MovieApi
import kotlinx.coroutines.launch

enum class MovieApiStatus { LOADING, ERROR, DONE }
class MovieViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MovieApiStatus>()
    // The external immutable LiveData for the request status
    val status: LiveData<MovieApiStatus> = _status

    private val _photos = MutableLiveData<List<ResultsItem?>>()
    val photos: LiveData<List<ResultsItem?>> = _photos



    init {
        getCountryPhotos()
    }


    private fun getCountryPhotos() {
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                _photos.value = MovieApi.retrofitService.getMovie().results!!
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MovieApiStatus.ERROR
                // to clear the RecyclerView.
                _photos.value = listOf()

            }
        }
    }
}
