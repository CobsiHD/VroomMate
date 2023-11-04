package com.example.vroommate.request

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.vroommate.activity.MainActivity
import org.json.JSONObject


class CarRequest(private val context: Context, private val updatable: MainActivity) {

    companion object {

        private const val URL = "http://51.68.91.213/gr-1-5/cars.json"
    }

    init {

        val queue = Volley.newRequestQueue(context)
        val request = JsonObjectRequest(
            Request.Method.GET,
            URL,
            null,
            { res ->
                //updatable.updateActions()
                Log.d("VolleyResponse", "Response is: $res")
                refresh(res)
                Toast.makeText(context, "succes", Toast.LENGTH_SHORT).show()
            },
            { err ->
                Log.e("VolleyError", "Error: ${err.localizedMessage}")
                Log.e("ActionRequest", "Error: ${err.toString()}")
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
            }
        )

        queue.add(request)
    }


    fun refresh(res: JSONObject) {
        Log.d("REFRESH_REQUEST", res.toString())
    }


}