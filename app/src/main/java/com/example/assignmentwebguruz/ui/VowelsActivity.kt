package com.example.assignmentwebguruz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.assignmentwebguruz.R
import com.example.assignmentwebguruz.databinding.ActivityMainBinding
import com.example.assignmentwebguruz.databinding.ActivityVowelsBinding

class VowelsActivity : AppCompatActivity() {

    var vowels : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityVowelsBinding: ActivityVowelsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_vowels)

        vowels = intent.getStringExtra(getString(R.string.vowels)).toString()
        activityVowelsBinding.tvVowels.text = vowels

    }
}