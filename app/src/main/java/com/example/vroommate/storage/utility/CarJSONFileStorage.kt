package com.example.vroommate.storage.utility

import android.content.Context
import com.example.vroommate.model.Car
import org.json.JSONObject
import com.example.vroommate.storage.utility.file.JSONFileStorage
class CarJSONFileStorage (context: Context): JSONFileStorage<Car>(context, "car") {
    override fun create(id: Int, obj: Car): Car {
        return Car(
            id,
            obj.modele,
            obj.marque,
            obj.moteur,
            obj.puissance,
            obj.couple,
            obj.acceleration,
            obj.maxRPM,
            obj.vMax,
            obj.like,
            obj.image
        )
    }

    override fun objectToJson(id: Int, obj: Car): JSONObject {
        val json = JSONObject()
        json.put(Car.ID, id)
        json.put(Car.MODELE, obj.modele)
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
            json.getInt(Car.ID),
            json.getString(Car.MODELE),
            json.getString(Car.MARQUE),
            json.getString(Car.MOTEUR),
            json.getString(Car.PUISSANCE),
            json.getString(Car.COUPLE),
            json.getString(Car.ACCELERATION),
            json.getString(Car.MAXRPM),
            json.getString(Car.VMAX),
            json.getBoolean(Car.LIKE),
            json.getString(Car.IMAGE)
        )
    }
}


