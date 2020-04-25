package com.example.poject1.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.model.Patient
import kotlinx.android.synthetic.main.waiting_item.view.*

class WaitingRoomViewHolder(itemView: View,private val onHealthyBtnClicked: (Int) -> Unit,
                            private val onHospitalisationBtnClicked: (Int) -> Unit):RecyclerView.ViewHolder(itemView) {


    init{
        itemView.waitingRoomZdravBtn.setOnClickListener {
            onHealthyBtnClicked.invoke(adapterPosition)
        }
        itemView.waitingRoomHospitalizacijaBtn.setOnClickListener {
            onHospitalisationBtnClicked.invoke(adapterPosition)
        }

    }

    fun bind(patient:Patient){
        itemView.waitingPatientName.text = patient.name
        itemView.waitingPatientSurname.text = patient.surname
        itemView.waitingpatientSimptoms.text = patient.arrivedSimptoms
        //Picasso.get().load("https://image.shutterstock.com/image-vector/human-icon-people-picture-profile-260nw-1012771615.jpg").into(itemView.patientImg)


    }


}