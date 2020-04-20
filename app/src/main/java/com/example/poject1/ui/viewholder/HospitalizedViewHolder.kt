package com.example.poject1.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.listeners.OnRecordBtnClick
import com.example.poject1.listeners.OnReleaseBtnClick
import com.example.poject1.model.Patient
import kotlinx.android.synthetic.main.hospitalized_item.view.*

class HospitalizedViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {


    fun bind(patient: Patient,onReleaseBtnClick: OnReleaseBtnClick,onRecordBtnClick: OnRecordBtnClick){
        itemView.hospitalizedPatientName.text = patient.name
        itemView.hospitalizedPatientSurname.text = patient.surname

        itemView.hospitalizedReleaseBtn.setOnClickListener {
            onReleaseBtnClick.onReleaseBtnClick(patient)
        }
        itemView.hospitalizedKartonBtn.setOnClickListener {
            onRecordBtnClick.onRecordBtnClick(patient)
        }
    }
}