package com.example.prTest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prTest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySecondBinding
    private lateinit var mAdapter: SecondAdapter
    private var mList: ArrayList<String> = arrayListOf()

    //불필요한 주석, 주석 삭제 요청해주시면 수정 할 수 있게 달아논 주석입니다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)
        setUpValue()
    }

    private fun setUpValue() {
        setData()
        mAdapter = SecondAdapter(mList)
        mBinding.secondRecyclerView.adapter = mAdapter
        mBinding.secondRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.setItemClickListener(object : SecondAdapter.ItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@SecondActivity, mList[position]+"이 클릭 되었습니다.", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setData() {
        for (index in 1..100) {
            mList.add(index.toString())
        }
    }
}