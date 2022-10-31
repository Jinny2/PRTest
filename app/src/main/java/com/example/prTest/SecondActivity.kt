package com.example.prTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.prTest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        setUpValue()
        setUpEvent()
    }
    private fun setUpValue(){
        //mBinding.secondRecyclerView.adapter
    }
    private fun setUpEvent(){

    }
    private fun test(){
        
    }
}