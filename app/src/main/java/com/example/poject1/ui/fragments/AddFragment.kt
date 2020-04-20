package com.example.poject1.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.poject1.R
import com.example.poject1.model.Patient
import com.example.poject1.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.ThreadLocalRandom

class AddFragment : Fragment(R.layout.fragment_add) {

    private val sharedMainViewModel: MainViewModel by activityViewModels()
    companion object{
        var idCounter = 0
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAddWaitingRoom.setOnClickListener{

            var simptoms = patientSimptomsET.text.toString()
            var name  = patientNameET.text.toString()
            var surname = patientSurnameET.text.toString()

            if(name==""){
                patientNameET.setError(this.resources.getString(R.string.IME_LOSE_UNESENO))
                return@setOnClickListener
            }
            else if(surname==""){
                patientSurnameET.setError(this.resources.getString(R.string.PREZIME_LOSE_UNESENO))
                return@setOnClickListener

            }
            else if(simptoms==""){
                patientSimptomsET.setError(this.resources.getString(R.string.BOLNICA_LOSE_UNESENO))
                return@setOnClickListener
            }


            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val formatted = current.format(formatter)
            val patient = Patient(name,surname,simptoms,formatted)
            patient.id = AddFragment.idCounter
            AddFragment.idCounter++

            patientSimptomsET.text.clear()
            patientNameET.text.clear()
            patientSurnameET.text.clear()

            sharedMainViewModel.increasePatientsInWaitingRoom()
            sharedMainViewModel.addPatientsToWaiting(patient)
        }
    }


}