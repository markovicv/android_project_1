package com.example.poject1.ui.fragments


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.poject1.Konstants
import com.example.poject1.R
import com.example.poject1.model.MedicalWorker
import com.example.poject1.ui.activities.LoginActivity
import com.example.poject1.viewmodels.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val profileViewModel:ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val medicalWorker:MedicalWorker = activity?.intent?.getParcelableExtra(Konstants.MED_PERSON) as MedicalWorker

        medicalWorker.let {
            profileViewModel.setMedicalWorker(it)
        }
        profileViewModel.getMedicalWorker().observe(viewLifecycleOwner, Observer {
            medWorkerNameTv.text = it.name
            medWorkerSurnameTv.text = it.surname
            medworkerJobTv.text = it.hospital
        })
        odjavaMedBtn.setOnClickListener {
            val editor = activity?.getSharedPreferences(Konstants.MEDICAL_PREFERENCE,Context.MODE_PRIVATE)?.edit()
            editor?.clear()
            editor?.apply()
            val intent:Intent = Intent(activity,LoginActivity::class.java)
            startActivity(intent)
        }

    }
}