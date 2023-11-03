package com.example.vroommate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vroommate.json.JsonDownloader

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche)

        // Créez une instance de JsonDownloader
        val jsonDownloader = JsonDownloader()

        // Appelez la méthode pour récupérer le JSON
        jsonDownloader.fetchJsonData(object : JsonDownloader.JsonDownloadCallback {
            override fun onJsonDownloaded(json: String) {
                // Traitez le JSON ici
                // Vous pouvez appeler des fonctions pour analyser le JSON et mettre à jour l'UI
            }

            override fun onError(error: String) {
                // Gérez les erreurs ici
            }
        })
    }
}
