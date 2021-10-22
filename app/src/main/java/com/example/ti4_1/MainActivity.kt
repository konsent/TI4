package com.example.ti4_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, loadingscreen::class.java)
        startActivity(intent)

        main_btn_newgame.setOnClickListener {
            val intent = Intent(this, newgame_1::class.java)
            startActivity(intent)
        }
        main_btn_loadgame.setOnClickListener {
            val intent = Intent(this, scoringboard2::class.java)
            startActivity(intent)
        }
    }
}
