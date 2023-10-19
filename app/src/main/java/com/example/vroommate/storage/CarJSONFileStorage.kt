package com.example.vroommate.storage

import android.content.Context
import com.example.vroommate.model.Car
import org.json.JSONObject
import com.example.vroommate.storage.utility.JSONFileStorage
class CarJSONFileStorage (context: Context): JSONFileStorage<Car>(context, "car") {
    override fun create(modele : String, obj: Car): Car {
        return Car(modele, obj.marque, obj.moteur, obj.puissance, obj.couple, obj.acceleration, obj.maxRPM, obj.vMax, obj.like, obj.image)
    }

    override fun objectToJson(modele : String, obj: Car): JSONObject {
        val json = JSONObject()
        json.put(Car.MODELE, modele)
        json.put(Car.MARQUE, obj.marque)
        json.put(Car.MOTEUR, obj.moteur)
        json.put(Car.PUISSANCE, obj.puissance)
        json.put(Car.COUPLE, obj.couple)
        json.put(Car.ACCELERATION, obj.acceleration)
        json.put(Car.MAXRPM, obj.maxRPM)
        json.put(Car.VMAX, obj.vMax)
        json.put(Car.LIKE, obj.like)
        json.put(Car.IMAGE, obj.image)

        return json
    }

    override fun jsonToObject(json: JSONObject): Car {
        return Car(
            json.getString(Car.MODELE),
            json.getString(Car.MARQUE),
            json.getString(Car.MOTEUR),
            json.getString(Car.PUISSANCE),
            json.getString(Car.COUPLE),
            json.getString(Car.ACCELERATION),
            json.getString(Car.MAXRPM),
            json.getString(Car.VMAX),
            json.getBoolean(Car.LIKE),
            json.getString(Car.IMAGE),
        )
    }

}


    override fun jsonToObject(json: JSONObject): Expense {
        return Expense(
            json.getInt(Expense.ID),
            json.getString(Expense.NAME),
            json.getInt(Expense.CATEGORY),
            json.getString(Expense.AMOUNT),
            json.getString(Expense.DATE),
            json.getInt(Expense.AUTHOR)
        )
    }
}