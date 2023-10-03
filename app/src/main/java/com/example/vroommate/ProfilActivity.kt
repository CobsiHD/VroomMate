package com.example.vroommate

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {


    private lateinit var editTextBrand: EditText
    private lateinit var editTextModel: EditText
    private lateinit var editTextEngine: EditText
    private lateinit var editTextPower: EditText
    private lateinit var editTextCouple: EditText
    private lateinit var editText0100: EditText
    private lateinit var editTextRPM: EditText
    private lateinit var editTextSpeed: EditText


    private lateinit var imageViewProfile: ImageView
    private lateinit var imageViewCar: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil) // Assurez-vous que le nom du layout est correct

        // Initialise views
        editTextBrand = findViewById(R.id.editTextBrand)
        editTextModel = findViewById(R.id.editTextModel)
        editTextEngine = findViewById(R.id.editTextEngine)
        editTextPower = findViewById(R.id.editTextPower)
        editTextCouple= findViewById(R.id.editTextCouple)
        editText0100= findViewById(R.id.editText0100)
        editTextRPM= findViewById(R.id.editTextRPM)
        editTextSpeed= findViewById(R.id.editTextSpeed)

        imageViewProfile = findViewById(R.id.imageViewProfile)
        imageViewCar = findViewById(R.id.imageViewCar)


        // Mise en place d'une action pour prendre une photo lorsque l'image est cliquée
        val takePhoto = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap: Bitmap? ->
            // Si la photo est prise avec succès (c.-à-d., bitmap non null), mettez à jour l'imageView
            bitmap?.let { imageViewCar.setImageBitmap(it) }
        }

        imageViewCar.setOnClickListener {
            // Au clic, lance la capture d'une photo
            takePhoto.launch(null)
        }

        imageViewProfile.setOnClickListener {
            // Vous pouvez également ajouter une fonctionnalité pour changer la photo de profil ici
        }

        // Set click listener for Save Profile button
        findViewById<Button>(R.id.buttonSaveProfile).setOnClickListener {
            // Implement save profile functionality
            // Exemple: sauvegarder les données dans une base de données ou les préférences partagées
        }
    }
}
