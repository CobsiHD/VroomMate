package com.example.vroommate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vroommate.R
import com.example.vroommate.model.Car

abstract class CarAdapter(private val cars:List<Car> ) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val marqueTextView: TextView = itemView.findViewById(R.id.marque)
        //val modeleTextView: TextView = itemView.findViewById(R.id.modele)
        val moteurTextView: TextView = itemView.findViewById(R.id.moteur)
        val puissanceTextView: TextView = itemView.findViewById(R.id.puissance)
        val coupleTextView: TextView = itemView.findViewById(R.id.couple)
        val accelerationTextView: TextView = itemView.findViewById(R.id.acceleration)
        val maxRPMTextView: TextView = itemView.findViewById(R.id.maxRPM)
        val vMaxTextView: TextView = itemView.findViewById(R.id.vMax)
        //val imageimageView: TextView = itemView.findViewById(R.id.image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_car, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]
        holder.marqueTextView.text = car.marque
        //holder.modeleTextView.text = car.modele
        holder.moteurTextView.text = car.moteur
        holder.puissanceTextView.text = car.puissance
        holder.coupleTextView.text = car.couple
        holder.accelerationTextView.text = car.acceleration
        holder.maxRPMTextView.text = car.maxRPM
        holder.vMaxTextView.text = car.vMax
        //holder.imageimageView.setImageResource(car.imageResId) // Décommentez cette ligne une fois que vous avez l'image appropriée
    }

}
