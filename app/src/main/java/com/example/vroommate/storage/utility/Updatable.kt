package com.example.vroommate.storage.utility

import com.example.vroommate.model.Car

interface Updatable {
    fun update(cars: List<Car>)
}
