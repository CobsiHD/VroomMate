package com.example.vroommate.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.vroommate.ProfileActivity
import com.example.vroommate.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vroommate.adapter.CarAdapter
import com.example.vroommate.model.Car
import com.example.vroommate.request.CarRequest
import com.example.vroommate.storage.utility.Updatable


class MainActivity : AppCompatActivity(), Updatable {

    private lateinit var carRequest: CarRequest
    private lateinit var carAdapter: CarAdapter
    private lateinit var recyclerView: RecyclerView
    private val carList = mutableListOf<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView and Adapter
        recyclerView = findViewById(R.id.rvCars)
        carAdapter = CarAdapter(carList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = carAdapter

        // Initialize CarRequest
        carRequest = CarRequest(this, this)

        val btnProfile: ImageButton = findViewById(R.id.btn_profil)
        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    override fun update(cars: List<Car>) {
        carList.clear()
        carList.addAll(cars)
        carAdapter.notifyDataSetChanged()
    }
}
