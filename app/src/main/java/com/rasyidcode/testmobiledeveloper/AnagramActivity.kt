package com.rasyidcode.testmobiledeveloper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rasyidcode.testmobiledeveloper.databinding.ActivityAnagramBinding

class AnagramActivity : AppCompatActivity(){

    private val binding by lazy { DataBindingUtil.setContentView<ActivityAnagramBinding>(this, R.layout.activity_anagram) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            btnTry.setOnClickListener {
                val word1 = editWord1.text.toString()
                val word2 = editWord2.text.toString()

                if (word1.isEmpty() || word2.isEmpty()) {
                    textResult.text = "Cannot be empty!"
                } else {
                    textResult.text = if (anagram(word1, word2)) {
                        "$word1 & $word2 is Anagram."
                    } else {
                        "$word1 & $word2 is not Anagram."
                    }
                }
            }
        }
    }

    private fun anagram(text1: String, text2: String) : Boolean {
        val t1 = text1.replace("/[^\\w]/g", "")
        val t2 = text2.replace("/[^\\w]/g", "")

        val charsA = getCharHash(t1)
        val charsB = getCharHash(t2)

        charsA.keys.forEach {
            if (charsA[it] != charsB[it]) {
                return false
            }
        }

        return true
    }

    private fun getCharHash(text: String) : HashMap<String, String> {
        val chars = HashMap<String, String>()

        text.split("").forEach {
            chars[it] = chars[it] + 1
        }

        return chars
    }

    /* another way */
    private fun anagram2(a: String, b: String) : Boolean {
        if (a.length != b.length) return false

        val chars = b.toMutableList()

        a.forEach {
            if (!chars.remove(it)) {
                return false
            }
        }

        return true
    }
}