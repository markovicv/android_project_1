package com.example.poject1.ui.diff

import androidx.recyclerview.widget.DiffUtil
import com.example.poject1.model.Patient

class PatientDiffCallBack(val oldPatientList:List<Patient>,val newPatientList:List<Patient>):DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldPatientList.get(oldItemPosition).id == newPatientList.get(newItemPosition).id
    }

    override fun getOldListSize(): Int {
        return oldPatientList.size
    }

    override fun getNewListSize(): Int {
        return newPatientList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        var patient1 = oldPatientList.get(oldItemPosition)
        var patient2 = newPatientList.get(newItemPosition)

        return patient1.name == patient2.name && patient1.surname == patient2.surname
//                  patient1.arrivedSimptoms == patient2.arrivedSimptoms && patient1.arrived == patient2.arrived
//                && patient1.currentState == patient2.currentState && patient1.released == patient2.released
    }
}