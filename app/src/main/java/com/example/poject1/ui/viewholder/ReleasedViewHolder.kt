package com.example.poject1.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.model.Patient
import kotlinx.android.synthetic.main.released_item.view.*

class ReleasedViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {



    fun bind(patient: Patient){
        itemView.releasedPatientName.text = patient.name
        itemView.releasedPatientSurname.text = patient.surname
        itemView.releasedPatientDate.text = patient.arrived
    }
}