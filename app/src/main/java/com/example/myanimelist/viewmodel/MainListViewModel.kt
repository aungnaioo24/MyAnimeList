package com.example.myanimelist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myanimelist.network.TmdbApi
import kotlinx.coroutines.launch

class MainListViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val name: LiveData<String> = _status


    private fun getName() {
        viewModelScope.launch {
            try {
                val listResult = TmdbApi.retrofitService.getAnimeSeries()
                _status.value = "Success!"
            } catch (e: Exception) {
                _status.value = "Error"
            }
        }
    }

}