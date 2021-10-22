package com.example.ti4_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.ti4_1.databinding.ActivityMainBinding
import java.util.*

class scoringboard2 : AppCompatActivity() {

    var sum_cbs = arrayListOf<Int>(0, 0, 0, 0, 0, 0)

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        fun sum(a: Int, b:Int): Int{
            return a + b
        }

        val objectives1 = mutableListOf("전술/전략 물자 아무 조합 토큰 총 3개 소비", // 1번 임무 10개 리스트
            "  두 가지 색상 기술 각각 2개 보유  ",
            "  동일 특성 행성 4개 점령  ",
            "  기술 전문화 행성 3개 점령  ",
            "  영향력 8 소비  ",
            "  메카톨 렉스 인접 성계 2개에 각각 함선 보유  ",
            "  자원 8개 소비  ",
            "  고향 외 성계 행성 6개 점령  ",
            "  유닛 향상 기술 2개 보유  ",
            "  무역품 5개 소비  ")

        val objectives2 = mutableListOf("  동일 특성 행성 6개 점령  ", // 2번 임무 10개 리스트
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

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_scoringboard2)

        val set: TreeSet<Int> = TreeSet()  // 임무 랜덤 분배
        while(set.size < 5){
            val random = Random()
            val num = random.nextInt(10)
            set.add(num)
        }
        var nCount2 = 0
        for( i in set ) { // 2번 미션 랜덤으로 골라서 5개 집어넣기
            val tmpID : Int = resources.getIdentifier("obj" + (nCount2 + 1), "id", packageName )
            val tmpID_selected = findViewById<TextView>(tmpID)
            tmpID_selected.setText(objectives1.get(i))
            nCount2++ }
        for (i in 3..5){ // 1번 2번 임무 제외 3번부터 5번미션 선택하기
            val btn1 : Int = resources.getIdentifier("btn" + (i), "id", packageName )
            val btn_selected = findViewById<TextView>(btn1)
            val obj_reveal1 : Int = resources.getIdentifier("obj" + (i), "id", packageName )
            val obj_selected = findViewById<TextView>(obj_reveal1)
            btn_selected.setOnClickListener{
                obj_selected.visibility = View.VISIBLE
            }
        }
//        for (i in 3..5){ // 1번 2번 임무 제외 3번부터 5번미션 선택하기
//            val btn1 : Int = resources.getIdentifier("btn" + (i), "id", packageName )
//            val btn_selected = findViewById<TextView>(btn1)
//            val obj_reveal1 : Int = resources.getIdentifier("obj" + (i), "id", packageName )
//            val obj_selected = findViewById<TextView>(obj_reveal1)
//            btn_selected.setOnClickListener{
//                obj_selected.visibility = View.VISIBLE
//            }
//        }
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
    }
}