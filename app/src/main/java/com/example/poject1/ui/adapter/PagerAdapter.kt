package com.example.poject1.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.poject1.ui.fragments.AddFragment
import com.example.poject1.ui.fragments.ListFragment
import com.example.poject1.ui.fragments.ProfileFragment
import com.example.poject1.ui.fragments.StateFragment

class PagerAdapter(fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object{
        private const val ITEM_COUNT = 4
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
        const val FRAGMENT_4 = 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_1 -> StateFragment()
            FRAGMENT_2 -> AddFragment()
            FRAGMENT_3-> ListFragment()
            else->ProfileFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }
}