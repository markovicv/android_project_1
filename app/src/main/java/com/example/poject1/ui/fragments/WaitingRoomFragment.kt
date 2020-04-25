package com.example.poject1.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poject1.R
import com.example.poject1.ui.adapter.WaitingRoomAdapter
import com.example.poject1.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_waiting_room.*

class WaitingRoomFragment : Fragment(R.layout.fragment_waiting_room) {
    private val sharedMainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        waitingRoomRv.layoutManager = LinearLayoutManager(activity)
        val waitingRoomAdapter = WaitingRoomAdapter({
            sharedMainViewModel.remowePatientFromWaiting(it)
        },{
            sharedMainViewModel.addPatientsToHospitalized(it)
        })
        waitingRoomRv.adapter = waitingRoomAdapter
        sharedMainViewModel.getPatientsInWaitingRoom().observe(viewLifecycleOwner, Observer {
            waitingRoomAdapter.setWaitingRoomPatients(it)
        })
        findByNameOrSurnameWaitingRoom.doAfterTextChanged {
            sharedMainViewModel.findWaitingPatients(it.toString())
        }





    }


}