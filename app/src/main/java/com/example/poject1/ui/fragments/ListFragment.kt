package com.example.poject1.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.poject1.R
import com.example.poject1.ui.adapter.TabsAdapter
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabPager.adapter = TabsAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(tabPager)


    }
}