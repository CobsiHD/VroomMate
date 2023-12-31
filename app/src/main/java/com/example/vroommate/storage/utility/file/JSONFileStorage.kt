package com.example.vroommate.storage.utility.file

import android.content.Context
import android.util.Log
import org.json.JSONObject
import java.io.File

abstract class JSONFileStorage<T>(private val context: Context, name: String) : FileStorage<T>(context, name, ".json") {
    protected abstract fun objectToJson(id: Int, obj: T): JSONObject
    protected abstract fun jsonToObject(json: JSONObject): T

    override fun dataToString(data: HashMap<Int, T>): String {
        val json = JSONObject()
        data.forEach{pair -> json.put("${pair.key}", objectToJson(pair.key, pair.value))}
        return json.toString()
    }

    override fun stringToData(value: String): HashMap<Int, T> {
        val data = HashMap<Int, T>()
        val json = JSONObject(value)
        val iterator = json.keys()
        while(iterator.hasNext()){
            val key = iterator.next()
            data.put(key.toInt(),jsonToObject(json.getJSONObject(key)))
        }
        return data
    }



}