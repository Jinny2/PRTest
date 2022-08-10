package com.example.prTest.first.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prTest.databinding.ItemFirstBinding
import com.example.prTest.first.adapter.listener.ItemClickListener

class FirstAdapter(
    private val clickListener: ItemClickListener
) : RecyclerView.Adapter<FirstViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        return FirstViewHolder(
            ItemFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            clickListener
        )
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = 30
}