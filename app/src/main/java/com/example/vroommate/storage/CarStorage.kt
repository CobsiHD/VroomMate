package com.example.vroommate.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.vroommate.model.Car
import com.example.vroommate.storage.utility.CarJSONFileStorage
import com.example.vroommate.storage.utility.Storage

object CarStorage {
    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("com.example.vroommate.preferences", Context.MODE_PRIVATE)
    }

    fun getStorage(context: Context): Int {
        return 0
    }

    fun setStorage(context: Context, prefStorage: Int) {

    }

    fun get(context: Context): Storage<Car> {
        return CarJSONFileStorage(context)
    }
}