package com.example.vroommate

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vroommate.adapter.CarAdapter
import com.example.vroommate.model.Car
import com.example.vroommate.request.CarRequest
import com.example.vroommate.storage.utility.Updatable

class RechercheActivity : Activity(), Updatable {

    private lateinit var carRequest: CarRequest
    private lateinit var carAdapter: CarAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private val carList = mutableListOf<Car>()
    private val displayedCarList = mutableListOf<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche)

        // Initialiser la RecyclerView et l'adaptateur
        recyclerView = findViewById(R.id.recyclerView)
        carAdapter = CarAdapter(displayedCarList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = carAdapter

        // Initialiser CarRequest
        carRequest = CarRequest(this, this)

        // Initialiser la barre de recherche et son écouteur
        searchView = findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false // Pas besoin de gérer la soumission du texte de recherche ici
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterCars(newText)
                return true
            }
        })
    }

    private fun filterCars(query: String?) {
        val filteredList = if (query.isNullOrEmpty()) {
            carList
        } else {
            carList.filter { car ->
                // Vérifie si la requête est contenue dans l'une des caractéristiques de la voiture
                query.lowercase() in car.marque.lowercase() ||
                        query.lowercase() in car.modele.lowercase() ||
                        query.lowercase() in car.moteur.lowercase() ||
                        query.lowercase() in car.puissance.lowercase() ||
                        query.lowercase() in car.couple.lowercase() ||
                        query.lowercase() in car.acceleration.lowercase() ||
                        query.lowercase() in car.maxRPM.lowercase() ||
                        query.lowercase() in car.vMax.lowercase()
            }
        }
        displayedCarList.clear()
        displayedCarList.addAll(filteredList)
        carAdapter.notifyDataSetChanged()
    }

    override fun update(cars: List<Car>) {
        carList.clear()
        carList.addAll(cars)
        filterCars(searchView.query.toString())
    }
}
