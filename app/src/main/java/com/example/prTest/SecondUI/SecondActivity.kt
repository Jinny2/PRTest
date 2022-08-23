package com.example.prTest.SecondUI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prTest.R
import com.example.prTest.SecondAdapter
import com.example.prTest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySecondBinding
    private lateinit var mAdapter: SecondAdapter
    private var mList: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        setData()
        initAdapter()
    }

    private fun setData() {
        for (index in 1..100) {
            mList.add(index.toString())
        }
    }

    private fun initAdapter(){
        mAdapter = SecondAdapter(mList)
        mBinding.secondRecyclerView.adapter = mAdapter
        mBinding.secondRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.setItemClickListener(object : SecondAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                val myIntent = Intent(this@SecondActivity, SecondItemDetailActivity::class.java)
                myIntent.putExtra("numData", mList[position])
                startActivity(myIntent)
            }
        })
    }
}