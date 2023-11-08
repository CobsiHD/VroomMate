package com.example.vroommate.request

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.vroommate.activity.MainActivity
import com.example.vroommate.model.Car
import com.example.vroommate.storage.utility.CarJSONFileStorage
import com.example.vroommate.storage.utility.Updatable
import org.json.JSONObject


class CarRequest(private val context: Context, private val updatable: Updatable) {

    companion object {

        private const val URL = "http://51.68.91.213/gr-1-5/cars.json"
    }

    init {

        val queue = Volley.newRequestQueue(context)
        val request = JsonObjectRequest(
            Request.Method.GET,
            URL,
            null,
            { res ->
                //updatable.updateActions()
                Log.d("VolleyResponse", "Response is: $res")
                refresh(res)
                Toast.makeText(context, "succes", Toast.LENGTH_SHORT).show()
            },
            { err ->
                Log.e("VolleyError", "Error: ${err.localizedMessage}")
                Log.e("ActionRequest", "Error: ${err.toString()}")
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
            }
        )

        queue.add(request)
    }


    fun refresh(res: JSONObject) {
        val carsArray = res.getJSONArray("voitures") // Obtenez le tableau JSON de voitures
        val cars = mutableListOf<Car>()

        // Itérer à travers le tableau de voitures
        for (i in 0 until carsArray.length()) {
            val carJSON = carsArray.getJSONObject(i) // Obtenez l'objet JSON de voiture à l'index i

            // Extraire les informations de la voiture avec des valeurs par défaut si nécessaire
            val id = carJSON.optInt("id")
            val marque = carJSON.optString("marque")
            val modele = carJSON.optString("modele")
            val moteur = carJSON.optString("moteur")
            val puissance = carJSON.optString("puissance")
            val couple = carJSON.optString("couple")
            val acceleration = carJSON.optString("0 a 100 kmh", "N/A") // Valeur par défaut si non trouvé
            val maxRPM = carJSON.optString("max RPM", "N/A") // Utilisez une valeur par défaut si la clé "max_RPM" n'existe pas
            val vMax = carJSON.optString("Vitesse max", "N/A") // Valeur par défaut si non trouvé
            val like = carJSON.optBoolean("like", false)
            val image = carJSON.optString("image", "gtr35") // Valeur par défaut si non trouvé

            // Créer un objet Car avec les informations extraites
            val car = Car(id, marque, modele, moteur, puissance, couple, acceleration, maxRPM, vMax, like, image)
            cars.add(car)
        }
        updatable.update(cars)
    }



}