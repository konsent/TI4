package com.example.ti4_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class loadingscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loadingscreen)
        startLoading()
    }
    private fun startLoading(){
        val handler = Handler()
        handler.postDelayed({ finish() }, 1000)
    }
}