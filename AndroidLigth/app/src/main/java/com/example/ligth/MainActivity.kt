package com.example.ligth

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Image: ImageView = findViewById(R.id.image)
        Image.setImageResource(R.drawable.icons8_light_off_96)
        val on: Switch = findViewById(R.id.switch1)
        on.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Image.setImageResource(R.drawable.icons8_light_on_96)
                run("http://192.168.0.101/light/1:5000")
            } else {
                Image.setImageResource(R.drawable.icons8_light_off_96)
                run("http://192.168.0.101/light/1:5000")
            }
        }
    }
    fun run(url: String) {
        val request = Request.Builder()
            .url(url).build()

        client.newCall(request)
    }
}