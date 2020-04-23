package com.example.poject1.ui.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poject1.Konstants
import com.example.poject1.R
import com.example.poject1.model.Patient
import kotlinx.android.synthetic.main.activity_patient.*

class PatientActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient)

        val patient = intent.getParcelableExtra(Konstants.PATIENT_RECORD) as Patient


        patientNameEditET.setText(patient.name)
        patientSurnameEditET.setText(patient.surname)
        patientSimptomsEditET.setText(patient.arrivedSimptoms)
        patientArrivedDate.setText(patient.arrived)

        patientIzmeniBtn.setOnClickListener {
            if(patientCurrentStateEditET.text.toString()!="")
                patient.currentState = patientCurrentStateEditET.text.toString()
            if(patientNameEditET.text.toString()!="")
                patient.name = patientNameEditET.text.toString()
            if(patientSurnameEditET.text.toString()!="")
                patient.surname = patientSurnameEditET.text.toString()
            if(patientSimptomsEditET.text.toString()!="")
                patient.arrivedSimptoms = patientSimptomsEditET.text.toString()
            val intent = Intent()
            intent.putExtra(Konstants.PATIENT_RECORD,patient)
            setResult(Activity.RESULT_OK,intent)
            finish()


        }
        patientOdustaniBtn.setOnClickListener {
            onBackPressed()
        }


    }
}