package com.hengki.aplicationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hengki.aplicationtest.databinding.ActivityEmptyBinding
import com.hengki.aplicationtest.databinding.ActivityMainBinding
import com.hengki.aplicationtest.ui.auth.LoginActivity
import com.inyongtisto.myhelper.extension.intentActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun mainButton(){
        binding.apply {
            btnLogin.setOnClickListener {
                intentActivity(LoginActivity::class.java)
            }
            btnRegister.setOnClickListener {
                intentActivity(LoginActivity::class.java)
            }
        }
    }
}