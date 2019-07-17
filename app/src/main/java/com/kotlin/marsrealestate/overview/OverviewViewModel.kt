package com.kotlin.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.marsrealestate.network.MarsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        getMarsRealEstateProperties()
    }

    fun getMarsRealEstateProperties() {
        uiScope.launch {
            val getPropertiesDeferred = MarsApi.retrofitService.getPropertiesAsync()
            try {
                val listResult = getPropertiesDeferred.await()
                _response.value = "Success: ${listResult.size} Mars properties retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
