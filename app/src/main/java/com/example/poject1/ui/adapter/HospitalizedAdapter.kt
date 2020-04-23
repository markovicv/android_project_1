package com.example.poject1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.R
import com.example.poject1.listeners.OnRecordBtnClick
import com.example.poject1.listeners.OnReleaseBtnClick
import com.example.poject1.model.Patient
import com.example.poject1.ui.diff.PatientDiffCallBack
import com.example.poject1.ui.viewholder.HospitalizedViewHolder

class HospitalizedAdapter(val onReleaseBtnClick: OnReleaseBtnClick,val onRecordBtnClick: OnRecordBtnClick) : RecyclerView.Adapter<HospitalizedViewHolder>() {
    private var hospitalizedPatients = mutableListOf<Patient>()


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

        val diffCallBack = PatientDiffCallBack(hospitalizedPatients,newList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        hospitalizedPatients.clear()
        hospitalizedPatients.addAll(newList)
        diffResult.dispatchUpdatesTo(this)

    }
}