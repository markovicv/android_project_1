package com.example.poject1.ui.viewholder

import android.view.View
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.listeners.OnHealthyBtnClick
import com.example.poject1.listeners.OnHospitlaizedBtnClick
import com.example.poject1.model.Patient
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.waiting_item.view.*

class WaitingRoomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


    fun bind(patient:Patient,onHealthyBtnClick: OnHealthyBtnClick,onHospitlaizedBtnClick: OnHospitlaizedBtnClick){
        itemView.waitingPatientName.text = patient.name
        itemView.waitingPatientSurname.text = patient.surname
        itemView.waitingpatientSimptoms.text = patient.arrivedSimptoms
        //Picasso.get().load("https://image.shutterstock.com/image-vector/human-icon-people-picture-profile-260nw-1012771615.jpg").into(itemView.patientImg)

        itemView.waitingRoomZdravBtn.setOnClickListener {
            onHealthyBtnClick.onHealthyBtnClick(patient)
        }
        itemView.waitingRoomHospitalizacijaBtn.setOnClickListener {
            onHospitlaizedBtnClick.onHospitlaizedBtnClick(patient)
        }
    }


}