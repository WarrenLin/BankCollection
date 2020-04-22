package com.example.bankcollection.ui.home

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
import com.example.bankcollection.ui.model.Bank
import com.example.bankcollection.ui.web.WebViewActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = root.findViewById(R.id.rv)
        homeViewModel.banks.observe(viewLifecycleOwner, Observer {
            val layoutManager = LinearLayoutManager(activity)
            recyclerView.layoutManager = layoutManager
            val adapter = HomeAdapter(it, clickListener)
            recyclerView.adapter = adapter
        })
        return root
    }

    private val clickListener = object: HomeAdapter.OnClickListener {
        override fun clickItem(bank: Bank) {
            Log.i("HomeFragment", "clickItem: $bank")
            activity?.let { WebViewActivity.start(it, bank.url, bank.name) }
        }
    }

}
