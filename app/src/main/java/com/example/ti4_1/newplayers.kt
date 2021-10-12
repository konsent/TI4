package com.example.ti4_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_newplayers.*
import kotlinx.android.synthetic.main.activity_scoringboard.*

class newplayers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newplayers)

        if (intent.hasExtra("number1")) {
            var player_num = intent.getStringExtra("number1")

            if (player_num.equals("4")) {
                players_p4.visibility = VISIBLE
            } else if (player_num.equals("5")) {
                players_p4.visibility = VISIBLE
                players_p5.visibility = VISIBLE
            } else if (player_num.equals("6")) {
                players_p4.visibility = VISIBLE
                players_p5.visibility = VISIBLE
                players_p6.visibility = VISIBLE
            }

        }
        sub_btn_newgame2.setOnClickListener {
            if (intent.hasExtra("number1")){
                var player_num = intent.getStringExtra("number1")
                val intent3 = Intent(this, scoringboard::class.java)
                intent3.putExtra("p1name", players_p1.text.toString())
                intent3.putExtra("p2name", players_p2.text.toString())
                intent3.putExtra("p3name", players_p3.text.toString())
                intent3.putExtra("p4name", players_p4.text.toString())
                intent3.putExtra("p5name", players_p5.text.toString())
                intent3.putExtra("p6name", players_p6.text.toString())
                intent3.putExtra("number1", player_num.toString())

            startActivity(intent3)


            }



        }
    }
}








