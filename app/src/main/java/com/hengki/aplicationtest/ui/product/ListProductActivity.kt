package com.hengki.aplicationtest.ui.product

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hengki.aplicationtest.databinding.ActivityEmptyBinding
import com.hengki.aplicationtest.databinding.ActivityListproBinding

class ListProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListproBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListproBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}