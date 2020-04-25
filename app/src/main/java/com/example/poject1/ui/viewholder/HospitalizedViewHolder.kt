package com.example.poject1.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.model.Patient
import kotlinx.android.synthetic.main.hospitalized_item.view.*

class HospitalizedViewHolder(itemView:View,private val onReleaseBtnClick: (Int)->Unit,private val onRecordBtnClick: (Int)->Unit):RecyclerView.ViewHolder(itemView) {


    init {
        itemView.hospitalizedReleaseBtn.setOnClickListener {
            onReleaseBtnClick.invoke(adapterPosition)
        }
        itemView.hospitalizedKartonBtn.setOnClickListener {
            onRecordBtnClick.invoke(adapterPosition)
        }

    }

    fun bind(patient: Patient){
        itemView.hospitalizedPatientName.text = patient.name
        itemView.hospitalizedPatientSurname.text = patient.surname


    }
}