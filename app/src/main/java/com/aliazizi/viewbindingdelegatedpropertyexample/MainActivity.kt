package com.aliazizi.viewbindingdelegatedpropertyexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aliazizi.viewbindingdelegatedproperty.activity.viewBinding
import com.aliazizi.viewbindingdelegatedpropertyexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.activityMainMessage.text = "hello world"
    }
}