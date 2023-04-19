package com.example.pr_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // продолжительность 2 секунды и интервал тактов 1 секунда
        val timer = object : CountDownTimer(2000,1000){

            // метод, который вызывается каждый раз, когда тикает таймер
            override fun  onTick(millisUntilFinished: Long){}

            // метод, который вызывается, когда таймер заканчивает обратный отсчет
            override fun onFinish(){

                // переход на следующий экран
                val intent = Intent(this@MainActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        // запускает таймер обратного отсчета
        timer.start()
    }
}