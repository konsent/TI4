package com.example.ti4_1

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_scoringboard.*
import java.util.*
import android.widget.Spinner
import androidx.core.view.get


class scoringboard : AppCompatActivity(){

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {


        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        val objectives1 = mutableListOf<String>("  전술/전략 물자 아무 조합 토큰 총 3개 소비  ", // 1번 임무 10개 리스트
            "  두 가지 색상 기술 각각 2개 보유  ",
            "  동일 특성 행성 4개 점령  ",
            "  기술 전문화 행성 3개 점령  ",
            "  영향력 8 소비  ",
            "  메카톨 렉스 인접 성계 2개에 각각 함선 보유  ",
            "  자원 8개 소비  ",
            "  고향 외 성계 행성 6개 점령  ",
            "  유닛 향상 기술 2개 보유  ",
            "  무역품 5개 소비  ")

        val objectives2 = mutableListOf<String>("  동일 특성 행성 6개 점령  ", // 2번 임무 10개 리스트
            "  무역품 10개 소비  ",
            "  유닛 향상 기술 3개 보유  ",
            "  고향 외 성계 행성 11개 점령  ",
            "  자원 16개 소비  ",
            "  전술/전략 물자 아무 조합 토큰 총 6개 소비  ",
            "  기술 전문화 행성 5개 점령  ",
            "  4가지 색상의 기술 각각 2개씩 보유  ",
            "  영향력 16 소비  ",
            "  다른 플레이어의 고향 성계 행성 1개 점령  ")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoringboard)


        val set: TreeSet<Int> = TreeSet()  // 임무 랜덤 분배
        while(set.size < 5){
            val random = Random()
            val num = random.nextInt(10)
            set.add(num)
        }
        var nCount2 = 0
        for( i in set ) { // 2번 미션 랜덤으로 골라서 5개 집어넣기
            val tmpID : Int = getResources().getIdentifier("obj" + (nCount2 + 1), "id", packageName )
            val tmpID_selected = findViewById<TextView>(tmpID)
            tmpID_selected.setText(objectives1.get(i))
            nCount2++ }
        for (i in 3..5){ // 1번 2번 임무 제외 3번부터 5번미션 선택하기
            val btn1 : Int = getResources().getIdentifier("btn" + (i), "id", packageName )
            val btn_selected = findViewById<TextView>(btn1)
            val obj_reveal1 : Int = getResources().getIdentifier("obj" + (i), "id", packageName )
            val obj_selected = findViewById<TextView>(obj_reveal1)
            btn_selected.setOnClickListener{
                obj_selected.visibility = View.VISIBLE
            }
        }
        var nCount = 0
        for( i in set ) { // 2번 미션 랜덤으로 골라서 5개 집어넣기
            val tmpID : Int = getResources().getIdentifier("obj2" + (nCount + 1), "id", packageName )
            val tmpID_selected = findViewById<TextView>(tmpID)
            tmpID_selected.setText(objectives2.get(i))
            nCount++ }
        for (i in 1..5){ // 2번 미션 5개
            val btn2 : Int = getResources().getIdentifier("btn2" + (i), "id", packageName )
            val btn_selected2 = findViewById<TextView>(btn2)
            val obj_reveal2 : Int = getResources().getIdentifier("obj2" + (i), "id", packageName )
            val obj_selected2 = findViewById<TextView>(obj_reveal2)
            btn_selected2.setOnClickListener{
                obj_selected2.visibility = View.VISIBLE
            }
        }
        if (intent.hasExtra("number1")) { // 전 액티비티에서 고른 플레이어 수 만큼 플레이어 컬럼 숨김을 해제한다
            val player_num2 = intent.getStringExtra("number1")

            if (player_num2.equals("4")) {
                linearLayout4.visibility = View.VISIBLE
            } else if (player_num2.equals("5")) {
                linearLayout4.visibility = View.VISIBLE
                linearLayout5.visibility = View.VISIBLE
            } else if (player_num2.equals("6")) {
                linearLayout4.visibility = View.VISIBLE
                linearLayout5.visibility = View.VISIBLE
                linearLayout6.visibility = View.VISIBLE
            }



            val sb_spinner_secret_p1: Spinner = findViewById(R.id.sb_secret1) // 비밀목표 드랍다운 #1
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p1.adapter = adapter
            }

            val sb_spinner_mr_p1: Spinner = findViewById(R.id.sb_mr1) // 메카톨렉스 드랍다운 #1
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p1.adapter = adapter
            }

//            val sb_spinner_secret_p1 = findViewById<View>(R.id.sb_secret1) as Spinner
//            val text = sb_spinner_secret_p1.getItemAtPosition()




    // sb_spinner_secret_p1와 sb_spinner_mr_p1에서 선택된 값을 Int로 받아서 합계를 내고
    // xml에 있는 sb_p1_sum<Textview>에 넣고싶음 (두 스피너 값은 계속 바뀜)

    // 질문#1 - 서브클래스(함수 안?)에 선언된 스피너 값을 수퍼클래스(함수 밖?)에 있는 value에 집어넣을 수 있는지?
    // 질문#2 - 선택된 스피너 값은 string인지? toString().toInt()로 더하려고하면 textview에 숫자가 안뜨고 글자들이 뜸
    // plus나 add 혹은 sum()함수를 선언해서 그냥 두 값을 더해버리면 되는지?

           // 첫번째 스피너 값 불러오기
           sb_spinner_secret_p1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
               override fun onNothingSelected(position: AdapterView<*>?) {}
               override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                   sb_spinner_secret_p1.setSelection(position, false)
                   var sb_spinner_secret_p1 = parent?.setSelection(position)
               }
           }
           // 두번째 스피너 값 불러오기
            sb_spinner_mr_p1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(position: AdapterView<*>?) {}
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    sb_spinner_mr_p1.setSelection(position, false)
                    val sb_spinner_mr_p1 = parent?.getItemAtPosition(position)
                }
            }






            val sb_spinner_secret_p2: Spinner = findViewById(R.id.sb_secret2) // 비밀목표 드랍다운 #2
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p2.adapter = adapter
            }

            val sb_spinner_secret_p3: Spinner = findViewById(R.id.sb_secret3) // 비밀목표 드랍다운 #3
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p3.adapter = adapter
            }

            val sb_spinner_secret_p4: Spinner = findViewById(R.id.sb_secret4) // 비밀목표 드랍다운 #4
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p4.adapter = adapter
            }

            val sb_spinner_secret_p5: Spinner = findViewById(R.id.sb_secret5) // 비밀목표 드랍다운 #5
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p5.adapter = adapter
            }

            val sb_spinner_secret_p6: Spinner = findViewById(R.id.sb_secret6) // 비밀목표 드랍다운 #6
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p6.adapter = adapter
            }



            val sb_spinner_mr_p2: Spinner = findViewById(R.id.sb_mr2) // 메카톨렉스 드랍다운 #2
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p2.adapter = adapter
            }

            val sb_spinner_mr_p3: Spinner = findViewById(R.id.sb_mr3) // 메카톨렉스 드랍다운 #3
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p3.adapter = adapter
            }

            val sb_spinner_mr_p4: Spinner = findViewById(R.id.sb_mr4) // 메카톨렉스 드랍다운 #4
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p4.adapter = adapter
            }

            val sb_spinner_mr_p5: Spinner = findViewById(R.id.sb_mr5) // 메카톨렉스 드랍다운 #5
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p5.adapter = adapter
            }

            val sb_spinner_mr_p6: Spinner = findViewById(R.id.sb_mr6) // 메카톨렉스 드랍다운 #6
            ArrayAdapter.createFromResource(
                this,
                R.array.secret,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p6.adapter = adapter
            }


            for (i in 1 until 7) {
                val id = "sb_p$i"
                val idd: Int = resources.getIdentifier(id, "id", packageName)
                val textView: TextView = findViewById<TextView>(idd)
                if (intent.hasExtra("p" + (i) + "name")) {
                    textView.text = intent.getStringExtra("p" + (i) + "name")
                }

            }
        }
    }
    }




