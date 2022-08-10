package com.example.prTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.prTest.databinding.ActivitySecondItemDetailBinding

class SecondItemDetailActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySecondItemDetailBinding
    private lateinit var mData: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second_item_detail)
        mData = intent.getStringExtra("numData") as String
        mBinding.numTxt.text = mData
    }
}