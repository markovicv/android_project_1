package com.example.poject1.ui.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.poject1.Konstants
import com.example.poject1.R
import com.example.poject1.model.Patient
import com.example.poject1.ui.activities.PatientActivity
import com.example.poject1.ui.adapter.HospitalizedAdapter
import com.example.poject1.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_hospitalized.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class HospitalizedFragment : Fragment(R.layout.fragment_hospitalized){

    private val sharedMainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val patientR = activity?.intent?.getParcelableExtra(Konstants.PATIENT_RECORD) as Patient
//        patientR.let {
//            sharedMainViewModel.updateRecord(it)
//        }


        hospitalizedRv.layoutManager = LinearLayoutManager(activity)
        val hospitalizedAdapter = HospitalizedAdapter({
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val formatted = current.format(formatter)
            it.released = formatted
            sharedMainViewModel.addPatientsToReleased(it)
        },{
            val intent = Intent(activity,PatientActivity::class.java)
            intent.putExtra(Konstants.PATIENT_RECORD,it)
            startActivityForResult(intent,Konstants.CHANGE_PATIENT_STATUS);

        })
        hospitalizedRv.adapter = hospitalizedAdapter

        sharedMainViewModel.getHospitalizedPatients().observe(viewLifecycleOwner, Observer {
            hospitalizedAdapter.setHospitalizedPatients(it)
        })

        findByNameOrSurnameHospitalized.doAfterTextChanged {
            it.let {
                sharedMainViewModel.findHospitalizedPatients( it.toString())
            }

        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Konstants.CHANGE_PATIENT_STATUS && resultCode == RESULT_OK){

            sharedMainViewModel.updateRecord(data?.getParcelableExtra(Konstants.PATIENT_RECORD)as Patient)
            hospitalizedRv.adapter?.notifyDataSetChanged()

        }
    }
}