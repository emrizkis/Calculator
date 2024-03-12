package com.mikonku.calculator

import android.content.Intent
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.appcompat.app.AppCompatActivity as AppCompatActivity1

class MainActivity : AppCompatActivity1() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        val intent = Intent(this, BasicCalculatorActivity::class.java)
        startActivity(intent)
    }
}