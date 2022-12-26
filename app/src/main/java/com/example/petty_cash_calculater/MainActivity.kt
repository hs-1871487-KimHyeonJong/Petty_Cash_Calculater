package com.example.petty_cash_calculater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.petty_cash_calculater.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {

        }

        binding.CalcButton.setOnClickListener {
            val intent = Intent(this,CalcActivity::class.java)
            startActivity(intent)
        }



    }


}