package com.example.prTest.first

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prTest.databinding.ActivityFirstBinding
import com.example.prTest.first.adapter.FirstAdapter
import com.example.prTest.first.adapter.listener.ItemClickListener
import com.example.prTest.first.detail.FirstDetailActivity

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() {
        binding.rvView.apply {
            layoutManager = LinearLayoutManager(this@FirstActivity, LinearLayoutManager.VERTICAL, false)
            adapter = FirstAdapter(object : ItemClickListener {
                override fun onItemClick() {
                    startActivity(Intent(this@FirstActivity, FirstDetailActivity::class.java))
                }
            })
        }
    }
}