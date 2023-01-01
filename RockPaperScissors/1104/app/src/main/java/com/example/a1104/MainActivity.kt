package com.example.a1104

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.a1104.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var Scissors: Button
    lateinit var Rock: Button
    lateinit var Paper: Button
    lateinit var Result: TextView
    lateinit var ResultCount: TextView
    lateinit var Reset: Button
    var WinCount = 0
    var LoseCount = 0
    var DrawCount = 0


    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Scissors=findViewById(R.id.button1)
        Rock=findViewById(R.id.button2)
        Paper=findViewById(R.id.button3)
        Result=findViewById(R.id.textView)
        ResultCount=findViewById(R.id.textView2)
        Reset=findViewById(R.id.button4)

        Scissors.setOnClickListener(){
            Game(1,"가위")
        }
        Rock.setOnClickListener(){
            Game(2,"바위")
        }
        Paper.setOnClickListener(){
            Game(3,"보")
        }
        Reset.setOnClickListener(){
            GameReset()

        }
    }

    private fun Game(num:Int,Str:String){
        var ResultText:String
        var ran = Random.nextInt(3)+1

        if(ran==1){
            ResultText = "가위"
        } else if(ran==2){
            ResultText = "바위"
        }else{
            ResultText = "보"
        }

        if(ran==num){
            Result.text = "무"
            DrawCount++
            Toast.makeText(this,""+Str+"vs"+ResultText+"\n비겼습니다.",Toast.LENGTH_SHORT).show()
            ResultCount.text = WinCount.toString() + "승" + DrawCount + "무" + LoseCount + "패"
        }else if((ran==1 && num==2) || (ran==2 && num==3) || (ran==3 && num==1)){
            Result.text = "승"
            WinCount++
            Toast.makeText(this,""+Str+"vs"+ResultText+"\n이겼습니다.",Toast.LENGTH_SHORT).show()
            ResultCount.text = WinCount.toString() + "승" + DrawCount + "무" + LoseCount + "패"
        }else{
            Result.text = "패"
            LoseCount++
            Toast.makeText(this,""+Str+"vs"+ResultText+"\n졌습니다.",Toast.LENGTH_SHORT).show()
            ResultCount.text = WinCount.toString() + "승" + DrawCount + "무" + LoseCount + "패"
        }

    }

    private fun GameReset(){
        Result.text = "-"
        WinCount = 0
        LoseCount = 0
        DrawCount = 0
        Toast.makeText(this,"초기화 합니다.",Toast.LENGTH_SHORT).show()
        ResultCount.text = WinCount.toString() + "승" + DrawCount + "무" + LoseCount + "패"

    }


}