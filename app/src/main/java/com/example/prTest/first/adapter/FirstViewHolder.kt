package com.example.prTest.first.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.prTest.databinding.ItemFirstBinding
import com.example.prTest.first.adapter.listener.ItemClickListener

class FirstViewHolder(
    private val binding: ItemFirstBinding,
    private val clickListener: ItemClickListener
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.setOnClickListener {
            clickListener.onItemClick()
        }
    }

    fun bind(index: Int) {
        binding.tvNum.text = index.toString()
    }
}