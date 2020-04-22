package com.example.bankcollection.ui.card

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bankcollection.R
import com.example.bankcollection.ui.model.CreditCard
import com.example.bankcollection.ui.web.WebViewActivity

class CardFragment : Fragment() {

    private lateinit var cardViewModel: CardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        cardViewModel =
                ViewModelProviders.of(this).get(CardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.rv)

        cardViewModel.cards.observe(viewLifecycleOwner, Observer {
            val layoutManager = LinearLayoutManager(activity)
            recyclerView.layoutManager = layoutManager
            val adapter = CardAdapter(it, clickListener)
            recyclerView.adapter = adapter
        })
        return root
    }

    private val clickListener = object: CardAdapter.OnClickListener {
        override fun clickItem(card: CreditCard) {
            Log.i("CardFragment", "clickItem: $card")
            activity?.let { WebViewActivity.start(it, card.url, card.title) }
        }
    }
}
