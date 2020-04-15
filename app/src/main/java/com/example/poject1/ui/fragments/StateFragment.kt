package com.example.poject1.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.poject1.R
import com.example.poject1.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_state.*

class StateFragment : Fragment(R.layout.fragment_state) {


    private val sharedMainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedMainViewModel.getPatientsInWaitingRoom().observe(viewLifecycleOwner, Observer {
            waitingRoomId.setText(it.toString())
        })
    }


}