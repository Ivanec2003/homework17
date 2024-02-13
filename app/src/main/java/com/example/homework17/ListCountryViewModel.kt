package com.example.homework17

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListCountryViewModel(
    private val repository: ListCountryRepository
):ViewModel() {
    private val _listCountry = MutableLiveData<List<CountryModel>>()
    val listCountry: LiveData<List<CountryModel>>
        get() = _listCountry

    fun fetchListCountry(){
        val result = repository.fetchListCountry()
        _listCountry.value = result
    }
    fun saveListCountry(){
        repository.saveListCountry()
    }
}