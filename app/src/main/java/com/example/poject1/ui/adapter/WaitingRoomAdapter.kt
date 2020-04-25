package com.example.poject1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.R
import com.example.poject1.model.Patient
import com.example.poject1.ui.diff.PatientDiffCallBack
import com.example.poject1.ui.viewholder.WaitingRoomViewHolder

class WaitingRoomAdapter(private val onBtnHealthyClicked: (Patient) -> Unit,
                         private val onBtnHospitalisationClicked: (Patient) -> Unit) : RecyclerView.Adapter<WaitingRoomViewHolder>() {
    private val waitingRoomPatientsList = mutableListOf<Patient>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaitingRoomViewHolder {
      //  return WaitingRoomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.waiting_item,parent,false))
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.waiting_item,parent,false)
        return WaitingRoomViewHolder(containerView,{
            val patient = waitingRoomPatientsList.get(it)
            onBtnHealthyClicked.invoke(patient)
        },{
            val patient = waitingRoomPatientsList.get(it)
            onBtnHospitalisationClicked.invoke(patient)
        })
    }

    override fun getItemCount(): Int {
        return waitingRoomPatientsList.size
    }

    override fun onBindViewHolder(holder: WaitingRoomViewHolder, position: Int) {
        holder.bind(waitingRoomPatientsList.get(position))

    }

    fun setWaitingRoomPatients(newList:List<Patient>){
        val diffCallBack = PatientDiffCallBack(waitingRoomPatientsList,newList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        waitingRoomPatientsList.clear()
        waitingRoomPatientsList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)

    }
}