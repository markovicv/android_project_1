package com.example.poject1.ui.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.poject1.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager.adapter = com.example.poject1.ui.adapter.PagerAdapter(supportFragmentManager)

        bnvId.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.stateId->{
                    viewPager.setCurrentItem(com.example.poject1.ui.adapter.PagerAdapter.FRAGMENT_1,false)

                }
                R.id.unosId->{
                    viewPager.setCurrentItem(com.example.poject1.ui.adapter.PagerAdapter.FRAGMENT_2,false)
                }
                R.id.listId->{
                    viewPager.setCurrentItem(com.example.poject1.ui.adapter.PagerAdapter.FRAGMENT_3,false )
                }

                R.id.profilId->{
                    viewPager.setCurrentItem(com.example.poject1.ui.adapter.PagerAdapter.FRAGMENT_4,false)

                }

            }
            true
        }
    }

}