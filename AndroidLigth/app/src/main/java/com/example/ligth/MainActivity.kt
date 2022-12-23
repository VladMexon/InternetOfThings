package com.example.ligth

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()

    @SuppressLint("MissingInflatedId", "UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Image: ImageView = findViewById(R.id.image)
        Image.setImageResource(R.drawable.icons8_light_off_96)
        val on: Switch = findViewById(R.id.switch1)
        on.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Image.setImageResource(R.drawable.icons8_light_on_96)
                run("http://192.168.0.101:5000/light/1")
            } else {
                Image.setImageResource(R.drawable.icons8_light_off_96)
                run("http://192.168.0.101:5000/light/0")
            }
        }
    }
    fun run(url: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                println(response.body!!.string())
            }
        })
    }
}
