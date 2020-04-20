package com.example.poject1.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.poject1.R
import com.example.poject1.ui.adapter.ReleasedAdapter
import com.example.poject1.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_hospitalized.*
import kotlinx.android.synthetic.main.fragment_released.*

class ReleasedFragment : Fragment(R.layout.fragment_released) {

    private val sharedMainViewModel: MainViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        releasedRv.layoutManager = GridLayoutManager(activity,2)
        val releasedAdapter = ReleasedAdapter()
        releasedRv.adapter = releasedAdapter

        sharedMainViewModel.getReleasedPatients().observe(viewLifecycleOwner, Observer {
            releasedAdapter.setReleasedPatientsList(it)
        })
        findByNameOrSurnameRelease.doAfterTextChanged {
            it.let {
                sharedMainViewModel.findReleasedPatients(it.toString())
            }

        }


    }
}