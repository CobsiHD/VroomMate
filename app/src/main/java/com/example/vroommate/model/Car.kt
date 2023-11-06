package com.example.vroommate.model

data class Car(
    val id: Int,
    val marque: String,
    val modele: String,
    val moteur: String,
    val puissance : String,
    val couple : String,
    val acceleration :String,
    val maxRPM : String,
    val vMax: String,
    val like: Boolean,
    val image : String
){
    companion object{
        const val ID = "id"
        const val MARQUE = "marque"
        const val MODELE = "modele"
        const val MOTEUR = "moteur"
        const val PUISSANCE = "puissance"
        const val COUPLE = "couple"
        const val ACCELERATION = "acceleration"
        const val MAXRPM = "maxRPM"
        const val VMAX = "vMax"
        const val LIKE = "like"
        const val IMAGE = "image"
    }

}
