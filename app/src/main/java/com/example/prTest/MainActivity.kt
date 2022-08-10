package com.example.prTest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.prTest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpEvent()
    }

    private fun setUpEvent() {
        mBinding.btn1.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }
        mBinding.btn2.setOnClickListener {
            mIntent = Intent(this, SecondActivity::class.java)
            startActivity(mIntent)
        }
    }
}