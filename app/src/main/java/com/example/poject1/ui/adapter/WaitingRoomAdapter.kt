package com.example.poject1.ui.adapter

import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.R
import com.example.poject1.listeners.OnHealthyBtnClick
import com.example.poject1.listeners.OnHospitlaizedBtnClick
import com.example.poject1.model.Patient
import com.example.poject1.ui.diff.PatientDiffCallBack
import com.example.poject1.ui.viewholder.WaitingRoomViewHolder
import java.util.Collections.addAll

class WaitingRoomAdapter(val onHealthyBtnClick: OnHealthyBtnClick,val onHospitlaizedBtnClick: OnHospitlaizedBtnClick) : RecyclerView.Adapter<WaitingRoomViewHolder>() {
    private val waitingRoomPatientsList = mutableListOf<Patient>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaitingRoomViewHolder {
        return WaitingRoomViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.waiting_item,parent,false))
    }

    override fun getItemCount(): Int {
        return waitingRoomPatientsList.size
    }

    override fun onBindViewHolder(holder: WaitingRoomViewHolder, position: Int) {
        holder.bind(waitingRoomPatientsList.get(position),onHealthyBtnClick,onHospitlaizedBtnClick)

    }

    fun setWaitingRoomPatients(newList:List<Patient>){
        val diffCallBack = PatientDiffCallBack(waitingRoomPatientsList,newList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        waitingRoomPatientsList.clear()
        waitingRoomPatientsList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)

    }
}