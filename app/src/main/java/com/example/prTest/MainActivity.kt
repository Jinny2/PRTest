package com.example.prTest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.prTest.databinding.ActivityMainBinding
import com.example.prTest.first.FirstActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setUpEvents()
    }

    private fun setUpEvents() {
        mBinding.btn1.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        mBinding.btn2.setOnClickListener {
            mIntent = Intent(this, SecondActivity::class.java)
            startActivity(mIntent)
        }
    }
}
// 3