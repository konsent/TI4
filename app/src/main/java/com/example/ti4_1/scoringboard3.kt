package com.example.ti4_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ti4_1.databinding.ActivityMainBinding

class scoringboard3 : AppCompatActivity() {

    var sum_cbs = arrayListOf<Int>(0, 0, 0, 0, 0, 0)
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

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
        setContentView(R.layout.activity_scoringboard3)
    }
}