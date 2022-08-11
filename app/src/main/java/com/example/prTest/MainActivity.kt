package com.example.prTest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.prTest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 테스트용 주석 달기 !!
    // 테스트용 주석 2개 달기 !!
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpEventsssssvvvvv()
    }

    private fun setUpEventsssssvvvvv() {
        mBinding.btn1.setOnClickListener {
            //주석입니다다ㅏㅏ
        }
        mBinding.btn2.setOnClickListener {
            mIntent = Intent(this, SecondActivity::class.java)
            startActivity(mIntent)
        }
    }
}