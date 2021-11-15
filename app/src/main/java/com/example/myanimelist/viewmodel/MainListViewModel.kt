package com.example.myanimelist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myanimelist.network.Serie
import com.example.myanimelist.network.TmdbApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainListViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _seriesObject = MutableLiveData<Serie>()
    val seriesObject: LiveData<Serie> = _seriesObject

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getAnimeSeries()
    }

    private fun getAnimeSeries() {
        coroutineScope.launch {
            var getAnimeSeriesDeferred = TmdbApi.retrofitService.getAnimeSeriesAsync()
            try {
                var listResult = getAnimeSeriesDeferred
                if(listResult.results.size>0) {
                    _seriesObject.value = listResult.results[0]
                }
            } catch (t: Throwable) {
                _status.value = "Failure: " + t.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}