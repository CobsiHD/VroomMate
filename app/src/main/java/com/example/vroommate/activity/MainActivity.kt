package com.example.vroommate.activity


import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.vroommate.ProfileActivity
import com.example.vroommate.R
import com.example.vroommate.model.Car
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vroommate.adapter.CarAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lier le bouton de profil à la ProfileActivity avec un Intent
        val btnProfile: ImageButton = findViewById(R.id.btn_profil)
        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        // Liste de voitures fictives
        val cars = listOf(
            Car("Tesla Model S", "Électrique", "762 ch", "0-100 km/h en 2,4 s", "250 km/h", "N/A", "967 Nm", 2020),
            Car("BMW i8", "Hybride", "374 ch", "0-100 km/h en 4,4 s", "250 km/h", "5800 rpm", "570 Nm", 2019),
            Car("Audi e-tron", "Électrique", "408 ch", "0-100 km/h en 5,7 s", "200 km/h", "N/A", "660 Nm", 2020),
            Car("Porsche Taycan", "Électrique", "625 ch", "0-100 km/h en 4,0 s", "260 km/h", "N/A", "1050 Nm", 2020),
            Car("Mercedes EQC", "Électrique", "408 ch", "0-100 km/h en 5,1 s", "180 km/h", "N/A", "760 Nm", 2020)
        )


        // Configuration du RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CarAdapter(cars)
    }
}

