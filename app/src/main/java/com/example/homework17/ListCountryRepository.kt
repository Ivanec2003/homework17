package com.example.homework17

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListCountryRepository(context: Context) {
    private val MODEL_KEY ="modelCountry"

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("shared_preferences", Context.MODE_PRIVATE)
    fun fetchListCountry(): List<CountryModel> {
        val savedListCountry = sharedPreferences.getString(MODEL_KEY, null)
        if (savedListCountry.isNullOrEmpty()){
            return emptyList()
        }
        val type = object : TypeToken<List<CountryModel>>() {}.type
        return Gson().fromJson(savedListCountry, type)
    }
    fun saveListCountry(){
        if(sharedPreferences.getString(MODEL_KEY, null).isNullOrEmpty()) {
            val listCountry = listOf(
                CountryModel(R.drawable.ic_launcher_background, "Ukraine"),
                CountryModel(R.drawable.ic_launcher_background, "Ukraine"),
                CountryModel(R.drawable.ic_launcher_background, "Ukraine"),
                CountryModel(R.drawable.ic_launcher_background, "Ukraine"),
                CountryModel(R.drawable.ic_launcher_background, "Ukraine"),
                CountryModel(R.drawable.ic_launcher_background, "Ukraine"),
                CountryModel(R.drawable.ic_launcher_background, "Ukraine"),
                CountryModel(R.drawable.ic_launcher_background, "Ukraine"),
                CountryModel(R.drawable.ic_launcher_background, "Ukraine"),
                CountryModel(R.drawable.ic_launcher_background, "Ukraine")
            )
            val saveListData = Gson().toJson(listCountry)
            sharedPreferences.edit().putString(MODEL_KEY, saveListData).apply()
        }
    }
}
