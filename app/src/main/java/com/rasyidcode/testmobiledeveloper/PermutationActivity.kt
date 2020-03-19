package com.rasyidcode.testmobiledeveloper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rasyidcode.testmobiledeveloper.databinding.ActivityPermutationBinding

class PermutationActivity : AppCompatActivity() {

    private val binding by lazy { DataBindingUtil.setContentView<ActivityPermutationBinding>(this, R.layout.activity_permutation) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            btnTry.setOnClickListener {
                if (editNumberN.text.isNullOrBlank() || editNumberR.text.isNullOrBlank()) {
                    textResult.text = "Cannot be empty :("
                } else {
                    val num1 = editNumberN.text.toString().toInt()
                    val num2 = editNumberR.text.toString().toInt()

                    textResult.text = "${permutation(num1, num2)}"
                }
            }
        }
    }

    private fun factorial(n: Int) : Int {
        var result = 1
        var i = n

        while(i > 0) {
            result *= i
            i--
        }

        return result
    }

    private fun permutation(n: Int, r: Int) : Int {
        var result = 1
        val divisor = factorial(n - r)

        if (divisor > 0) {
            result = factorial(n) / divisor
        }

        return result
    }
}