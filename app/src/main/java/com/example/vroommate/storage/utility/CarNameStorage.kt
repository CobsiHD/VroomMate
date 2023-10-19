package com.example.vroommate.storage.utility
import com.example.vroommate.model.Car
import com.example.vroommate.storage.utility.Storage

class CarNameStorage: Storage<Car> {
    override fun insert(obj: Car): Int {
        return 0
    }

    override fun size(): Int {
        return 0
    }

    override fun find(id: Int): Car? {
        return null
    }

    override fun findAll(): List<Car> {
        return emptyList()
    }

    override fun delete(id: Int) {
    }

    override fun update(id: Int, obj: Car) {
    }
}