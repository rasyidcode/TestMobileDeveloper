package com.rasyidcode.testmobiledeveloper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rasyidcode.testmobiledeveloper.databinding.ActivityFibonacciBinding

class FibonacciActivity : AppCompatActivity() {

    private val binding by lazy { DataBindingUtil.setContentView<ActivityFibonacciBinding>(this, R.layout.activity_fibonacci) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            btnCalculate.setOnClickListener {
                if (!editNumber.text.isNullOrEmpty()) {
                    textResult.text = "${fibonacci(editNumber.text.toString().toInt())}"
                } else {
                    textResult.text = "Don't make it empty :("
                }
            }
        }
    }

    private fun fibonacci(number: Int) : List<Int> {
        val arr: MutableList<Int> = mutableListOf(0, 1)
        var i = 2

        while(i < number + 1) {
            arr.add(arr[i - 2] + arr[i - 1])
            i++
        }

        return arr
    }

}
