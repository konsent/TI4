package com.example.ti4_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
//import com.example.ti4_1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_loadingscreen.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_newgame1.*


class newgame_1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newgame1)

        val Spinner: Spinner = findViewById(R.id.spinner_players) // P 수 드롭다운 스피너 메뉴
        ArrayAdapter.createFromResource(
            this,
            R.array.players_number,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            Spinner.adapter = adapter
        }

        val spinner2: Spinner = findViewById(R.id.spinner_vp) // 승점 드롭다운 스피너 메뉴
        ArrayAdapter.createFromResource(
            this,
            R.array.VP,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter

        }
        sub_btn_newgame.setOnClickListener { // NEW GAME 버튼

            var selectednumber1 = Spinner.selectedItem
            var selectednumber2 = spinner2.selectedItem
            val intent1 = Intent(this, newplayers::class.java) // 다음으로 넘어가는 버튼
            intent1.putExtra("number1", selectednumber1.toString())
            intent1.putExtra("number2", selectednumber2.toString())

            startActivity(intent1)



        }
    }
}
