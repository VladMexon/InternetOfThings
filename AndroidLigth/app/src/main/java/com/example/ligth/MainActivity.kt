package com.example.ligth

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.OkHttp
import okhttp3.Request
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onButton: Button = findViewById(R.id.button)
        onButton.setOnClickListener {
            run("http://192.168.0.101/light/1:5000")
        }
    }
    fun run(url: String) {
        val request = Request.Builder()
            .url(url).build()

        client.newCall(request)
    }
}