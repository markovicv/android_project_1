package com.example.poject1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.R
import com.example.poject1.listeners.OnRecordBtnClick
import com.example.poject1.listeners.OnReleaseBtnClick
import com.example.poject1.model.Patient
import com.example.poject1.ui.viewholder.HospitalizedViewHolder

class HospitalizedAdapter(val onReleaseBtnClick: OnReleaseBtnClick,val onRecordBtnClick: OnRecordBtnClick) : RecyclerView.Adapter<HospitalizedViewHolder>() {
    private var hospitalizedPatients:List<Patient> = ArrayList<Patient>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalizedViewHolder {
        return HospitalizedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.hospitalized_item,parent,false))
    }

    override fun getItemCount(): Int {
        return hospitalizedPatients.size
    }

    override fun onBindViewHolder(holder: HospitalizedViewHolder, position: Int) {
        holder.bind(hospitalizedPatients.get(position),onReleaseBtnClick,onRecordBtnClick)
    }

    fun setHospitalizedPatients(newList:List<Patient>){
        this.hospitalizedPatients = newList
        notifyDataSetChanged()
    }
}