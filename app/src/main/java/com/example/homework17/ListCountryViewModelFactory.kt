package com.example.homework17

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListCountryViewModelFactory(
    private val repository: ListCountryRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListCountryViewModel::class.java))
            return ListCountryViewModel(repository) as T
        throw IllegalArgumentException("Unknown model")
    }
}