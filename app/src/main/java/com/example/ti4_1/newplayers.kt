package com.example.ti4_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_newplayers.*


class newplayers : AppCompatActivity() {

    var vp = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newplayers)

        if (intent.hasExtra("number1")) { // 직전 액티비티에서 가져온 P 수에 따라 textview 숨김해제
            val player_num = intent.getStringExtra("number1")

            when {
                player_num.equals("4") -> {
                    players_p4.visibility = VISIBLE
                }
                player_num.equals("5") -> {
                    players_p4.visibility = VISIBLE
                    players_p5.visibility = VISIBLE
                }
                player_num.equals("6") -> {
                    players_p4.visibility = VISIBLE
                    players_p5.visibility = VISIBLE
                    players_p6.visibility = VISIBLE
                }
            }
        }
        if (intent.hasExtra("number2")) { // 직전 액티비티에서 가져온 VP(승점)
            val vpPoint = intent.getStringExtra("number2")
            vp = vpPoint.toString()

            sub_btn_newgame2.setOnClickListener { // P 이름 기록 후 다음 액티비티로 넘기기
                if (intent.hasExtra("number1")) {
                    val player_num = intent.getStringExtra("number1")
                    val intent3 = Intent(this, scoringboard3::class.java)
                    intent3.putExtra("p1name", players_p1.text.toString())
                    intent3.putExtra("p2name", players_p2.text.toString())
                    intent3.putExtra("p3name", players_p3.text.toString())
                    intent3.putExtra("p4name", players_p4.text.toString())
                    intent3.putExtra("p5name", players_p5.text.toString())
                    intent3.putExtra("p6name", players_p6.text.toString())
                    intent3.putExtra("vpNumber", vp)
                    intent3.putExtra("number1", player_num.toString())

                    startActivity(intent3)
                }
            }
        }
    }
}








