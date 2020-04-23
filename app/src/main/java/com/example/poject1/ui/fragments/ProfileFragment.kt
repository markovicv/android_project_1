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
import com.example.poject1.ui.activities.EditProfileActivity
import com.example.poject1.ui.activities.LoginActivity
import com.example.poject1.viewmodels.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val profileViewModel:ProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val medicalWorker = activity?.intent?.getParcelableExtra(Konstants.MED_PERSON) as MedicalWorker
        medWorkerNameTv.text = medicalWorker.name
        medWorkerSurnameTv.text = medicalWorker.surname
        medworkerJobTv.text = medicalWorker.hospital



        odjavaMedBtn.setOnClickListener {
            val editor = activity?.getSharedPreferences(Konstants.MEDICAL_PREFERENCE,Context.MODE_PRIVATE)?.edit()
            editor?.clear()
            editor?.apply()
            val intent:Intent = Intent(activity,LoginActivity::class.java)
            startActivity(intent)
        }
        izmeniMedBtn.setOnClickListener {
            val intent = Intent(activity,EditProfileActivity::class.java)
            intent.putExtra(Konstants.MED_PERSON,medicalWorker)
            startActivity(intent)
        }

    }

}