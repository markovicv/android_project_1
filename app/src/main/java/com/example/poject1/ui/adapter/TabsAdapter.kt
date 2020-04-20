package com.example.poject1.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.poject1.ui.fragments.HospitalizedFragment
import com.example.poject1.ui.fragments.ReleasedFragment
import com.example.poject1.ui.fragments.WaitingRoomFragment
import timber.log.Timber

class TabsAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {

        return when(position){

            0 ->{
                WaitingRoomFragment()
            }
            1 ->{
                HospitalizedFragment()
            }
            else->{
                ReleasedFragment()
            }

        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"waiting"
            1->"hospitalized"
            else ->{
                return "released"
            }
        }
    }
}