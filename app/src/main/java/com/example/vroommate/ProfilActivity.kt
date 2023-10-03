package com.example.vroommate

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import android.graphics.Bitmap
import android.provider.MediaStore
import android.content.Intent
import androidx.core.content.ContextCompat

class ProfileActivity : Activity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextSurname: EditText
    private lateinit var imageViewCar: ImageView
    private lateinit var editTextCarSpec: EditText

    // Initialisation des contrats pour la prise de photo ou le choix dans la galerie
    private val takePhoto = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        // Mise à jour de l'imageView avec le bitmap de la photo prise
        if (bitmap != null) {
            imageViewCar.setImageBitmap(bitmap)
        }
    }

    private val choosePhoto = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        // Mise à jour de l'imageView avec l'image choisie
        imageViewCar.setImageURI(uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        editTextName = findViewById(R.id.editTextName)
        editTextSurname = findViewById(R.id.editTextSurname)
        imageViewCar = findViewById(R.id.imageViewCar)
        editTextCarSpec = findViewById(R.id.editTextCarSpec)

        findViewById<Button>(R.id.buttonChooseImage).setOnClickListener {
            // Choix entre prendre une photo ou en choisir une depuis la galerie
            showPictureDialog()
        }

        findViewById<Button>(R.id.buttonSaveProfile).setOnClickListener {
            // Implémentez la fonctionnalité pour sauvegarder le profil
        }
    }





    private fun showPictureDialog() {
        //   capturer une photo avec la caméra
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        //  choisir une photo dans la galerie
        val choosePictureIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        // Vérifier si l'appareil peut gérer la de prise de photo
        val canTakePhoto: Boolean = takePictureIntent.resolveActivity(packageManager) != null
        // Choisissez une action en fonction de la possibilité de prendre une photo ou non
        if (canTakePhoto) {
            //  pour prendre une photo
            takePhoto.launch(null)
        } else {
            //   choisir une photo depuis la galerie
            choosePhoto.launch("image/*")
        }
    }
}
