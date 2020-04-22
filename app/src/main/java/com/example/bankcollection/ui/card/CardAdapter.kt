package com.example.bankcollection.ui.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bankcollection.R
import com.example.bankcollection.ui.model.Bank
import com.example.bankcollection.ui.model.CreditCard

class CardAdapter(private val cards: List<CreditCard>, private val clickListener: OnClickListener) :RecyclerView.Adapter<CardAdapter.Holder>() {

    interface OnClickListener {
        fun clickItem(card: CreditCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.module_recycle_card_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            clickListener.clickItem(cards[position])
        }

        Glide.with(holder.itemView)
            .load(cards[position].imageUrl)
            .centerCrop()
            .into(holder.image)

        holder.textTitle.text = cards[position].title
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textTitle: TextView = itemView.findViewById(R.id.tv_title)
        val image: ImageView = itemView.findViewById(R.id.image)
    }
}