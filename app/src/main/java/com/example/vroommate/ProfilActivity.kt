package com.example.vroommate

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.vroommate.model.Car
import com.example.vroommate.storage.utility.CarJSONFileStorage

class ProfileActivity : AppCompatActivity() {

    private lateinit var textViewName: EditText
    private lateinit var textViewSurname: EditText

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
        setContentView(R.layout.activity_profil)

        // Initialise views
        textViewName = findViewById(R.id.textViewName)
        textViewSurname = findViewById(R.id.textViewSurname)


        editTextBrand = findViewById(R.id.editTextBrand)
        editTextModel = findViewById(R.id.editTextModel)
        editTextEngine = findViewById(R.id.editTextEngine)
        editTextPower = findViewById(R.id.editTextPower)
        editTextCouple = findViewById(R.id.editTextCouple)
        editText0100 = findViewById(R.id.editText0100)
        editTextRPM = findViewById(R.id.editTextRPM)
        editTextSpeed = findViewById(R.id.editTextSpeed)

        imageViewProfile = findViewById(R.id.imageViewProfile)
        imageViewCar = findViewById(R.id.imageViewCar)

        // Mise en place d'une action pour prendre une photo lorsque l'image est cliquée
        val takePhoto =
            registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap: Bitmap? ->
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
            saveProfile()
        }

        // Charger les données de profil au lancement de l'activité
        loadProfile()
    }

    private fun saveProfile() {

        // création de mon obj expense
        val car = Car(
            0,
            editTextBrand.text.toString(),
            editTextModel.text.toString(),
            editTextEngine.text.toString(),
            editTextPower.text.toString(),
            editTextCouple.text.toString(),
            editText0100.text.toString(),
            editTextRPM.text.toString(),
            editTextSpeed.text.toString(),
            false,
            " "
        )
        // création du stor
        val stor = CarJSONFileStorage.get(applicationContext)
        Log.d("DialogAdd", stor.toString())
        stor.insert(car) // insertion de mon obj expense dans le stor


        // Après avoir enregistré, vous pouvez confirmer à l'utilisateur avec un Toast ou naviguer
        Toast.makeText(this, "Profil enregistré", Toast.LENGTH_SHORT).show()
        // Optionnel: Naviguer vers une autre activité ou fermer cette activité
        finish()
    }

    private fun loadProfile() {
        val stor = CarJSONFileStorage.get(applicationContext)
        val cars = stor.findAll()
        val car = cars.lastOrNull()  // Obtenez la dernière voiture enregistrée

        car?.let {
            editTextBrand.setText(it.marque)
            editTextModel.setText(it.modele)
            editTextEngine.setText(it.moteur)
            editTextPower.setText(it.puissance)
            editTextCouple.setText(it.couple)
            editText0100.setText(it.acceleration)
            editTextRPM.setText(it.maxRPM)
            editTextSpeed.setText(it.vMax)
            // Ici, vous devriez charger l'image de la voiture si vous avez enregistré le chemin de l'image
            // Par exemple, vous pouvez utiliser Glide ou Picasso pour charger l'image
            // Glide.with(this).load(File(it.imagePath)).into(imageViewCar)
        } ?: Toast.makeText(this, "Aucun profil de voiture enregistré.", Toast.LENGTH_SHORT).show()
    }
}