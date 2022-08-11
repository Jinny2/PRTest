package com.example.prTest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.prTest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 테스트용 주석 달기 !!
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpEvent()
    }

    private fun setUpEvent() {
        mBinding.btn1.setOnClickListener {
        }
        mBinding.btn2.setOnClickListener {
            mIntent = Intent(this, SecondActivity::class.java)
            startActivity(mIntent)
        }
    }
}