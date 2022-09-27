package com.example.idletapper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickButton= findViewById<Button>(R.id.click_button)
        val clickNumberText = findViewById<TextView>(R.id.click_number_text)
        val multiplyButton = findViewById<Button>(R.id.multiplierButton)
        val multiplierText = findViewById<TextView>(R.id.multiplier_text)
        var multiplier = 1
        var clickno = 0
        var clicksRequiredForUpgrade = 50

        fun add() {
            clickno+=(multiplier)
            clickNumberText.text = "Number of Clicks: $clickno"
        }

        fun addMultiplier() {
            if(clickno>=clicksRequiredForUpgrade){
                multiplier*=2
                multiplierText.text = "Multiplier: $multiplier"
                clickno-=clicksRequiredForUpgrade
                clicksRequiredForUpgrade*=2
            }

            else Toast.makeText(applicationContext, "$clicksRequiredForUpgrade clicks needed", Toast.LENGTH_SHORT).show()
        }

        clickButton.setOnClickListener {
            add()
        }
        multiplyButton.setOnClickListener {
            addMultiplier()
        }


    }


}