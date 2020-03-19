package com.rasyidcode.testmobiledeveloper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rasyidcode.testmobiledeveloper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnFibonacci.setOnClickListener { startActivity(Intent(this, FibonacciActivity::class.java)) }
        binding.btnAnagram.setOnClickListener { startActivity(Intent(this, AnagramActivity::class.java)) }
        binding.btnPermutation.setOnClickListener { startActivity(Intent(this, PermutationActivity::class.java)) }
    }
}
