package com.example.bankcollection.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bankcollection.R
import com.example.bankcollection.ui.model.Bank

class HomeAdapter(private val banks: List<Bank>, private val clickListener: OnClickListener) :RecyclerView.Adapter<HomeAdapter.Holder>() {

    interface OnClickListener {
        fun clickItem(bank: Bank)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.module_recycle_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return banks.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            clickListener.clickItem(banks[position])
        }

        holder.textTitle.text = "(" + banks[position].code + ") " + banks[position].name
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.findViewById(R.id.tv_title)
    }
}