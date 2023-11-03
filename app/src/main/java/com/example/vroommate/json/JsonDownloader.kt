package com.example.vroommate.json

import okhttp3.*
import java.io.IOException

class JsonDownloader {
    private val url = "http://51.68.91.213/gr-1-5/cars.json"
    private val client = OkHttpClient()

    interface JsonDownloadCallback {
        fun onJsonDownloaded(json: String)
        fun onError(error: String)
    }

    fun fetchJsonData(callback: JsonDownloadCallback) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                // Gérer les erreurs de connexion ici
                callback.onError(e.message ?: "Erreur de connexion")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val json = response.body?.string()
                    // Vous avez maintenant le contenu JSON dans la variable 'json'
                    // Vous pouvez le traiter et le parser comme décrit dans les étapes précédentes
                    if (json != null) {
                        callback.onJsonDownloaded(json)
                    } else {
                        callback.onError("Le JSON est vide")
                    }
                } else {
                    // Gérer les erreurs de réponse HTTP ici
                    callback.onError("Erreur de réponse HTTP : ${response.code}")
                }
            }
        })
    }
}
