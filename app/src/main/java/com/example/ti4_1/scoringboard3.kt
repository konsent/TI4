package com.example.ti4_1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.ti4_1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_scoringboard.*
import kotlinx.android.synthetic.main.activity_scoringboard.sb_mr4
import kotlinx.android.synthetic.main.activity_scoringboard.sb_p1_sum
import kotlinx.android.synthetic.main.activity_scoringboard.sb_p2_sum
import kotlinx.android.synthetic.main.activity_scoringboard.sb_p3_sum
import kotlinx.android.synthetic.main.activity_scoringboard.sb_p4_sum
import kotlinx.android.synthetic.main.activity_scoringboard.sb_p5_sum
import kotlinx.android.synthetic.main.activity_scoringboard.sb_p6_sum
import kotlinx.android.synthetic.main.activity_scoringboard.sb_secret1
import kotlinx.android.synthetic.main.activity_scoringboard.sb_secret2
import kotlinx.android.synthetic.main.activity_scoringboard.sb_secret3
import kotlinx.android.synthetic.main.activity_scoringboard.sb_secret4
import kotlinx.android.synthetic.main.activity_scoringboard.sb_secret5
import kotlinx.android.synthetic.main.activity_scoringboard.sb_secret6
import kotlinx.android.synthetic.main.activity_scoringboard3.*
import java.util.*
import kotlinx.android.synthetic.main.activity_scoringboard.sb_mr5 as sb_mr51
import kotlinx.android.synthetic.main.activity_scoringboard.sb_p5 as sb_p51
import kotlinx.android.synthetic.main.activity_scoringboard3.sb_mr6 as sb_mr61
import kotlinx.android.synthetic.main.activity_scoringboard3.sb_p4 as sb_p41
import kotlinx.android.synthetic.main.activity_scoringboard3.sb_p6 as sb_p61
import kotlin.toString as toString1

class scoringboard3 : AppCompatActivity() {

    var sum_cbs = arrayListOf<Int>(0, 0, 0, 0, 0, 0)
    var winner = ""
    var winPoint : Int = 0


    private lateinit var binding: ActivityMainBinding
    lateinit var alertDialog : AlertDialog
    lateinit var builder : AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {

        val objectives1 = mutableListOf(
            "  전술/전략 물자 아무 조합 토큰 총 3개 소비  ", // 1번 임무 10개 리스트
            "  두 가지 색상 기술 각각 2개 보유  ",
            "  동일 특성 행성 4개 점령  ",
            "  기술 전문화 행성 3개 점령  ",
            "  영향력 8 소비  ",
            "  메카톨 렉스 인접 성계 2개에 각각 함선 보유  ",
            "  자원 8개 소비  ",
            "  고향 외 성계 행성 6개 점령  ",
            "  유닛 향상 기술 2개 보유  ",
            "  무역품 5개 소비  "
        )

        val objectives2 = mutableListOf(
            "  동일 특성 행성 6개 점령  ", // 2번 임무 10개 리스트
            "  무역품 10개 소비  ",
            "  유닛 향상 기술 3개 보유  ",
            "  고향 외 성계 행성 11개 점령  ",
            "  자원 16개 소비  ",
            "  전술/전략 물자 아무 조합 토큰 총 6개 소비  ",
            "  기술 전문화 행성 5개 점령  ",
            "  4가지 색상의 기술 각각 2개씩 보유  ",
            "  영향력 16 소비  ",
            "  다른 플레이어의 고향 성계 행성 1개 점령  "
        )

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_scoringboard3)

        if (intent.hasExtra("vpNumber")) { // newgame_1.kt에서 설정한 승점(10/14점)을 가져온다
            val winPointNum = intent.getStringExtra("vpNumber")
            winPoint += winPointNum!!.toIntOrNull()!!
            Log.d("testX", winPoint.toString())
        }

        val set: TreeSet<Int> = TreeSet()  // 임무 랜덤 분배
        while (set.size < 5) {
            val random = Random()
            val num = random.nextInt(10)
            set.add(num)
        }
        var nCount2 = 0
        for (i in set) { // 2번 미션 랜덤으로 골라서 5개 집어넣기
            val tmpID: Int = resources.getIdentifier("obj" + (nCount2 + 1), "id", packageName)
            val tmpID_selected = findViewById<TextView>(tmpID)
            tmpID_selected.setText(objectives1.get(i))
            nCount2++
        }
        for (i in 3..5) { // 1번 2번 임무 제외 3번부터 5번미션 선택하기
            val btn1: Int = resources.getIdentifier("btn" + (i), "id", packageName)
            val btn_selected = findViewById<TextView>(btn1)
            val obj_reveal1: Int = resources.getIdentifier("obj" + (i), "id", packageName)
            val obj_selected = findViewById<TextView>(obj_reveal1)
            btn_selected.setOnClickListener {
                obj_selected.visibility = View.VISIBLE
            }
        }
        var nCount = 0
        for (i in set) { // 2번 미션 랜덤으로 골라서 5개 집어넣기
            val tmpID: Int = getResources().getIdentifier("obj2" + (nCount + 1), "id", packageName)
            val tmpID_selected = findViewById<TextView>(tmpID)
            tmpID_selected.setText(objectives2.get(i))
            nCount++
        }
        for (i in 1..5) { // 2번 미션 5개
            val btn2: Int = getResources().getIdentifier("btn2" + (i), "id", packageName)
            val btn_selected2 = findViewById<TextView>(btn2)
            val obj_reveal2: Int = getResources().getIdentifier("obj2" + (i), "id", packageName)
            val obj_selected2 = findViewById<TextView>(obj_reveal2)
            btn_selected2.setOnClickListener {
                obj_selected2.visibility = View.VISIBLE
            }
        }

        if (intent.hasExtra("number1")) { // 전 액티비티에서 고른 P 수 만큼 P 컬럼 숨김을 해제한다
            val player_num2 = intent.getStringExtra("number1")

            if (player_num2.equals("4")) {
                for(i in 1..10){
                    val chk4 = "chk4_$i"
                    val chk44 : Int = resources.getIdentifier(chk4, "id", packageName)
                    val chk444: CheckBox = findViewById<CheckBox>(chk44)
                    chk444.visibility = View.VISIBLE}
                    sb_secret4.visibility = View.VISIBLE
                    sb_mr4.visibility = View.VISIBLE
                    sb_p4_sum.visibility = View.VISIBLE
                    sb_p4.visibility = View.VISIBLE

            } else if (player_num2.equals("5")) {
                for(i in 1..10){
                    val chk4 = "chk4_$i"
                    val chk44 : Int = resources.getIdentifier(chk4, "id", packageName)
                    val chk444: CheckBox = findViewById<CheckBox>(chk44)
                    chk444.visibility = View.VISIBLE}
                    sb_secret4.visibility = View.VISIBLE
                    sb_mr4.visibility = View.VISIBLE
                    sb_p4_sum.visibility = View.VISIBLE
                    sb_p4.visibility = View.VISIBLE

                for(i in 1..10){
                    val chk5 = "chk5_$i"
                    val chk55 : Int = resources.getIdentifier(chk5, "id", packageName)
                    val chk555: CheckBox = findViewById<CheckBox>(chk55)
                    chk555.visibility = View.VISIBLE}
                    sb_secret5.visibility = View.VISIBLE
                    sb_mr5.visibility = View.VISIBLE
                    sb_p5_sum.visibility = View.VISIBLE
                    sb_p5.visibility = View.VISIBLE


            } else if (player_num2.equals("6")) {
                for(i in 1..10){
                    val chk4 = "chk4_$i"
                    val chk44 : Int = resources.getIdentifier(chk4, "id", packageName)
                    val chk444: CheckBox = findViewById<CheckBox>(chk44)
                    chk444.visibility = View.VISIBLE}
                    sb_secret4.visibility = View.VISIBLE
                    sb_mr4.visibility = View.VISIBLE
                    sb_p4_sum.visibility = View.VISIBLE
                    sb_p4.visibility = View.VISIBLE

                for(i in 1..10){
                    val chk5 = "chk5_$i"
                    val chk55 : Int = resources.getIdentifier(chk5, "id", packageName)
                    val chk555: CheckBox = findViewById<CheckBox>(chk55)
                    chk555.visibility = View.VISIBLE}
                    sb_secret5.visibility = View.VISIBLE
                    sb_mr5.visibility = View.VISIBLE
                    sb_p5_sum.visibility = View.VISIBLE
                    sb_p5.visibility = View.VISIBLE

                for(i in 1..10){
                    val chk6 = "chk6_$i"
                    val chk66 : Int = resources.getIdentifier(chk6, "id", packageName)
                    val chk666: CheckBox = findViewById<CheckBox>(chk66)
                    chk666.visibility = View.VISIBLE}
                    sb_secret6.visibility = View.VISIBLE
                    sb_p6_sum.visibility = View.VISIBLE
                    sb_mr6.visibility = View.VISIBLE
                    sb_p6.visibility = View.VISIBLE
            }



            val sb_spinner_secret_p1: Spinner = findViewById(R.id.sb_secret1) // 비밀목표 드랍다운 #1
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p1.adapter = adapter
            }

            val sb_spinner_secret_p2: Spinner = findViewById(R.id.sb_secret2) // 비밀목표 드랍다운 #2
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p2.adapter = adapter
            }

            val sb_spinner_secret_p3: Spinner = findViewById(R.id.sb_secret3) // 비밀목표 드랍다운 #3
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p3.adapter = adapter
            }

            val sb_spinner_secret_p4: Spinner = findViewById(R.id.sb_secret4) // 비밀목표 드랍다운 #4
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p4.adapter = adapter
            }

            val sb_spinner_secret_p5: Spinner = findViewById(R.id.sb_secret5) // 비밀목표 드랍다운 #5
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p5.adapter = adapter
            }

            val sb_spinner_secret_p6: Spinner = findViewById(R.id.sb_secret6) // 비밀목표 드랍다운 #6
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p6.adapter = adapter
            }

            val sb_spinner_mr_p1: Spinner = findViewById(R.id.sb_mr1) // 메카톨렉스 드랍다운 #1
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p1.adapter = adapter
            }

            val sb_spinner_mr_p2: Spinner = findViewById(R.id.sb_mr2) // 메카톨렉스 드랍다운 #2
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p2.adapter = adapter
            }

            val sb_spinner_mr_p3: Spinner = findViewById(R.id.sb_mr3) // 메카톨렉스 드랍다운 #3
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p3.adapter = adapter
            }

            val sb_spinner_mr_p4: Spinner = findViewById(R.id.sb_mr4) // 메카톨렉스 드랍다운 #4
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p4.adapter = adapter
            }

            val sb_spinner_mr_p5: Spinner = findViewById(R.id.sb_mr5) // 메카톨렉스 드랍다운 #5
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p5.adapter = adapter
            }

            val sb_spinner_mr_p6: Spinner = findViewById(R.id.sb_mr6) // 메카톨렉스 드랍다운 #6
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p6.adapter = adapter
            }

            val sbs_mr = mutableListOf(
                sb_spinner_mr_p1,
                sb_spinner_mr_p2,
                sb_spinner_mr_p3,
                sb_spinner_mr_p4,
                sb_spinner_mr_p5,
                sb_spinner_mr_p6
            )
            val sbs_secret = mutableListOf(
                sb_spinner_secret_p1,
                sb_spinner_secret_p2,
                sb_spinner_secret_p3,
                sb_spinner_secret_p4,
                sb_spinner_secret_p5,
                sb_spinner_secret_p6
            )
            val sbs_sum = mutableListOf(
                sb_p1_sum,
                sb_p2_sum,
                sb_p3_sum,
                sb_p4_sum,
                sb_p5_sum,
                sb_p6_sum
            )



            for (i in 1..6) {
                for (j in 1..10) {
                    val id_cb = "chk" + i + "_" + j
                    val id2_cb: Int = resources.getIdentifier(id_cb, "id", packageName)
                    val target_cb: CheckBox = findViewById<CheckBox>(id2_cb)

                    if (j < 6) {
                        // 체크박스 선택/선택해제시 Int 값 불러오기
                        target_cb.setOnCheckedChangeListener { _, isChecked ->
                            if (isChecked) {
                                sum_cbs.set(i - 1, sum_cbs.get(i - 1) + 1)
                            } else {
                                sum_cbs.set(i - 1, sum_cbs.get(i - 1) - 1)
                            }
                            // 여기 있어야 체크박스 누를 떄마다 업데이트가 됨
                            updateSum(sbs_mr[i - 1], sbs_secret[i - 1], sbs_sum[i - 1], i - 1)
                            for(k in 1..6){
                                if(sum_cbs[k-1] >= winPoint){
                                    getAlertShow(k)
                                }
                            }
                        }
                    } else {
                        // 체크박스 선택/선택해제시 Int 값 불러오기
                        target_cb.setOnCheckedChangeListener { _, isChecked ->
                            if (isChecked) {
                                sum_cbs.set(i - 1, sum_cbs.get(i - 1) + 2)
                            } else {
                                sum_cbs.set(i - 1, sum_cbs.get(i - 1) - 2)
                            }
                            // 여기 있어야 체크박스 누를 떄마다 업데이트가 됨
                            updateSum(sbs_mr[i - 1], sbs_secret[i - 1], sbs_sum[i - 1], i - 1)
                            for(k in 1..6){
                                if(sum_cbs[k-1] >= winPoint){
                                    getAlertShow(k)
                                }
                            }
                        }
                    }
                }
            }
            initSpinners(sb_spinner_mr_p1, sb_spinner_secret_p1, sb_p1_sum, 0)
            initSpinners(sb_spinner_mr_p2, sb_spinner_secret_p2, sb_p2_sum, 1)
            initSpinners(sb_spinner_mr_p3, sb_spinner_secret_p3, sb_p3_sum, 2)
            initSpinners(sb_spinner_mr_p4, sb_spinner_secret_p4, sb_p4_sum, 3)
            initSpinners(sb_spinner_mr_p5, sb_spinner_secret_p5, sb_p5_sum, 4)
            initSpinners(sb_spinner_mr_p6, sb_spinner_secret_p6, sb_p6_sum, 5)



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

    private fun initSpinners(sp_mr: Spinner, sp_secret: Spinner, sb_sum: TextView, idx: Int) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, (0..10).toList())
        val listener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateSum(sp_mr, sp_secret, sb_sum, idx)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        sp_mr.adapter = adapter
        sp_mr.onItemSelectedListener = listener
        sp_secret.adapter = adapter
        sp_secret.onItemSelectedListener = listener
    }

    // 각 Player별 스피너 값 및 체크박스 합계를 인자로 하는 함수 선언
    private fun updateSum(sb_mr: Spinner, sb_secret: Spinner, sb_sum: TextView, idx: Int) = with(binding) {
        val s1 = sb_secret.selectedItem?.toString()?.toIntOrNull() ?: 0
        val s2 = sb_mr.selectedItem?.toString()?.toIntOrNull() ?: 0
        val s3 = sum_cbs.get(idx)
        sb_sum.text = (s1 + s2 + s3).toString()
        }

    private fun getAlertShow(position: Int){
        try{
            val playerName = "sb_p$position"
            val playerNameId : Int = resources.getIdentifier(playerName,"id",packageName)
            val playerNameIdd = findViewById<TextView>(playerNameId)
            winner = playerNameIdd.text.toString()
            var str_title = winner
            var str_message = "승리하셨습니다."
            var str_btnOK = "하하 이 패배자들아"

            builder = AlertDialog.Builder(this@scoringboard3)
            builder.setTitle(str_title) //팝업창 타이틀 지정
            builder.setIcon(R.drawable.trophy) //팝업창 아이콘 지정
            builder.setMessage(str_message) //팝업창 내용 지정
            builder.setCancelable(false) //외부 레이아웃 클릭시도 팝업창이 사라지지않게 설정
            builder.setPositiveButton(str_btnOK, DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(application, "승리를 만끽하십시오", Toast.LENGTH_SHORT).show()
            })
            alertDialog = builder.create()
            try {alertDialog.show()
            }
            catch (e : Exception){
                e.printStackTrace()
            }
        }
        catch(e : Exception){
            e.printStackTrace()
        }
    }
}