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
            "  ??????/?????? ?????? ?????? ?????? ?????? ??? 3??? ??????  ", // 1??? ?????? 10??? ?????????
            "  ??? ?????? ?????? ?????? ?????? 2??? ??????  ",
            "  ?????? ?????? ?????? 4??? ??????  ",
            "  ?????? ????????? ?????? 3??? ??????  ",
            "  ????????? 8 ??????  ",
            "  ????????? ?????? ?????? ?????? 2?????? ?????? ?????? ??????  ",
            "  ?????? 8??? ??????  ",
            "  ?????? ??? ?????? ?????? 6??? ??????  ",
            "  ?????? ?????? ?????? 2??? ??????  ",
            "  ????????? 5??? ??????  "
        )

        val objectives2 = mutableListOf(
            "  ?????? ?????? ?????? 6??? ??????  ", // 2??? ?????? 10??? ?????????
            "  ????????? 10??? ??????  ",
            "  ?????? ?????? ?????? 3??? ??????  ",
            "  ?????? ??? ?????? ?????? 11??? ??????  ",
            "  ?????? 16??? ??????  ",
            "  ??????/?????? ?????? ?????? ?????? ?????? ??? 6??? ??????  ",
            "  ?????? ????????? ?????? 5??? ??????  ",
            "  4?????? ????????? ?????? ?????? 2?????? ??????  ",
            "  ????????? 16 ??????  ",
            "  ?????? ??????????????? ?????? ?????? ?????? 1??? ??????  "
        )

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(R.layout.activity_scoringboard3)

        if (intent.hasExtra("vpNumber")) { // newgame_1.kt?????? ????????? ??????(10/14???)??? ????????????
            val winPointNum = intent.getStringExtra("vpNumber")
            winPoint += winPointNum!!.toIntOrNull()!!
            Log.d("testX", winPoint.toString())
        }

        val set: TreeSet<Int> = TreeSet()  // ?????? ?????? ??????
        while (set.size < 5) {
            val random = Random()
            val num = random.nextInt(10)
            set.add(num)
        }
        var nCount2 = 0
        for (i in set) { // 2??? ?????? ???????????? ????????? 5??? ????????????
            val tmpID: Int = resources.getIdentifier("obj" + (nCount2 + 1), "id", packageName)
            val tmpID_selected = findViewById<TextView>(tmpID)
            tmpID_selected.setText(objectives1.get(i))
            nCount2++
        }
        for (i in 3..5) { // 1??? 2??? ?????? ?????? 3????????? 5????????? ????????????
            val btn1: Int = resources.getIdentifier("btn" + (i), "id", packageName)
            val btn_selected = findViewById<TextView>(btn1)
            val obj_reveal1: Int = resources.getIdentifier("obj" + (i), "id", packageName)
            val obj_selected = findViewById<TextView>(obj_reveal1)
            btn_selected.setOnClickListener {
                obj_selected.visibility = View.VISIBLE
            }
        }
        var nCount = 0
        for (i in set) { // 2??? ?????? ???????????? ????????? 5??? ????????????
            val tmpID: Int = getResources().getIdentifier("obj2" + (nCount + 1), "id", packageName)
            val tmpID_selected = findViewById<TextView>(tmpID)
            tmpID_selected.setText(objectives2.get(i))
            nCount++
        }
        for (i in 1..5) { // 2??? ?????? 5???
            val btn2: Int = getResources().getIdentifier("btn2" + (i), "id", packageName)
            val btn_selected2 = findViewById<TextView>(btn2)
            val obj_reveal2: Int = getResources().getIdentifier("obj2" + (i), "id", packageName)
            val obj_selected2 = findViewById<TextView>(obj_reveal2)
            btn_selected2.setOnClickListener {
                obj_selected2.visibility = View.VISIBLE
            }
        }

        if (intent.hasExtra("number1")) { // ??? ?????????????????? ?????? P ??? ?????? P ?????? ????????? ????????????
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



            val sb_spinner_secret_p1: Spinner = findViewById(R.id.sb_secret1) // ???????????? ???????????? #1
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p1.adapter = adapter
            }

            val sb_spinner_secret_p2: Spinner = findViewById(R.id.sb_secret2) // ???????????? ???????????? #2
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p2.adapter = adapter
            }

            val sb_spinner_secret_p3: Spinner = findViewById(R.id.sb_secret3) // ???????????? ???????????? #3
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p3.adapter = adapter
            }

            val sb_spinner_secret_p4: Spinner = findViewById(R.id.sb_secret4) // ???????????? ???????????? #4
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p4.adapter = adapter
            }

            val sb_spinner_secret_p5: Spinner = findViewById(R.id.sb_secret5) // ???????????? ???????????? #5
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p5.adapter = adapter
            }

            val sb_spinner_secret_p6: Spinner = findViewById(R.id.sb_secret6) // ???????????? ???????????? #6
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_secret_p6.adapter = adapter
            }

            val sb_spinner_mr_p1: Spinner = findViewById(R.id.sb_mr1) // ??????????????? ???????????? #1
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p1.adapter = adapter
            }

            val sb_spinner_mr_p2: Spinner = findViewById(R.id.sb_mr2) // ??????????????? ???????????? #2
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p2.adapter = adapter
            }

            val sb_spinner_mr_p3: Spinner = findViewById(R.id.sb_mr3) // ??????????????? ???????????? #3
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p3.adapter = adapter
            }

            val sb_spinner_mr_p4: Spinner = findViewById(R.id.sb_mr4) // ??????????????? ???????????? #4
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p4.adapter = adapter
            }

            val sb_spinner_mr_p5: Spinner = findViewById(R.id.sb_mr5) // ??????????????? ???????????? #5
            ArrayAdapter.createFromResource(this, R.array.secret, android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sb_spinner_mr_p5.adapter = adapter
            }

            val sb_spinner_mr_p6: Spinner = findViewById(R.id.sb_mr6) // ??????????????? ???????????? #6
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
                        // ???????????? ??????/??????????????? Int ??? ????????????
                        target_cb.setOnCheckedChangeListener { _, isChecked ->
                            if (isChecked) {
                                sum_cbs.set(i - 1, sum_cbs.get(i - 1) + 1)
                            } else {
                                sum_cbs.set(i - 1, sum_cbs.get(i - 1) - 1)
                            }
                            // ?????? ????????? ???????????? ?????? ????????? ??????????????? ???
                            updateSum(sbs_mr[i - 1], sbs_secret[i - 1], sbs_sum[i - 1], i - 1)
                            for(k in 1..6){
                                if(sum_cbs[k-1] >= winPoint){
                                    getAlertShow(k)
                                }
                            }
                        }
                    } else {
                        // ???????????? ??????/??????????????? Int ??? ????????????
                        target_cb.setOnCheckedChangeListener { _, isChecked ->
                            if (isChecked) {
                                sum_cbs.set(i - 1, sum_cbs.get(i - 1) + 2)
                            } else {
                                sum_cbs.set(i - 1, sum_cbs.get(i - 1) - 2)
                            }
                            // ?????? ????????? ???????????? ?????? ????????? ??????????????? ???
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

    // ??? Player??? ????????? ??? ??? ???????????? ????????? ????????? ?????? ?????? ??????
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
            var str_message = "?????????????????????."
            var str_btnOK = "?????? ??? ???????????????"

            builder = AlertDialog.Builder(this@scoringboard3)
            builder.setTitle(str_title) //????????? ????????? ??????
            builder.setIcon(R.drawable.trophy) //????????? ????????? ??????
            builder.setMessage(str_message) //????????? ?????? ??????
            builder.setCancelable(false) //?????? ???????????? ???????????? ???????????? ?????????????????? ??????
            builder.setPositiveButton(str_btnOK, DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(application, "????????? ??????????????????", Toast.LENGTH_SHORT).show()
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