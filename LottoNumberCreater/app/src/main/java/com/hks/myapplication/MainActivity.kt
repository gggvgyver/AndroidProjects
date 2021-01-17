package com.hks.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lotteryNumbers = arrayListOf(num_one, num_two, num_three, num_four, num_five, num_six)

        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                lotteryNumbers.forEach {
                    val randomNumber = (Math.random() * 45 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }

            override fun onFinish() {

            }
        }

        lottery_button.setOnClickListener {
            if (lottery_button.isAnimating) {
                lottery_button.cancelAnimation()
                countDownTimer.cancel()
            } else {
                lottery_button.playAnimation()
                money.playAnimation()
                countDownTimer.start()
            }
        }
    }
}