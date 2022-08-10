package com.example.prTest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SecondAdapter(val mList: ArrayList<String>) :
    RecyclerView.Adapter<SecondAdapter.ItemViewHolder>() {
    lateinit var mItemClickListener: ItemClickListener

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            itemView.setOnClickListener {
                mItemClickListener.onItemClick(adapterPosition)
            }
        }

        private val numTxt = view.findViewById<TextView>(R.id.numTxt)
        fun bind(item: String) {
            numTxt.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.second_item, parent, false)
        return ItemViewHolder(row)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        mItemClickListener = itemClickListener
    }

}