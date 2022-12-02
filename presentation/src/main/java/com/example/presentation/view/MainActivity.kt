package com.example.presentation.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.presentation.KakaoProvider
import com.example.presentation.R
import com.example.presentation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mIntent: Intent
    private lateinit var kakaoProvider: KakaoProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        kakaoProvider = KakaoProvider(this)
        setUpEvent()
        test()
    }

    private fun setUpEvent() {
        mBinding.btn1.setOnClickListener {
        }
        mBinding.btn2.setOnClickListener {
            mIntent = Intent(this, SecondActivity::class.java)
            startActivity(mIntent)
        }
        mBinding.btn3.setOnClickListener {

            CoroutineScope(Dispatchers.Main).launch {

                kakaoProvider.kakaoLogin().collect { user ->

                    Log.i("debugKakao", "kakaoLogin: $user")
                    mIntent = Intent(baseContext, ComposeTestActivity::class.java)
                    startActivity(mIntent)
                    finish()
                }
            }
        }
    }

    private fun test() {
        mIntent = Intent(this, SecondActivity::class.java)
        startActivity(mIntent)
    }
}