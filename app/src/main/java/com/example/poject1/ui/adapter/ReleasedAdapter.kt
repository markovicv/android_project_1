package com.example.poject1.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.poject1.R
import com.example.poject1.model.Patient
import com.example.poject1.ui.diff.PatientDiffCallBack
import com.example.poject1.ui.viewholder.ReleasedViewHolder

class ReleasedAdapter : RecyclerView.Adapter<ReleasedViewHolder>() {

    private var releasedPatientsList =  mutableListOf<Patient>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReleasedViewHolder {
        return ReleasedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.released_item,parent,false))
    }

    override fun getItemCount(): Int {
        return releasedPatientsList.size
    }

    override fun onBindViewHolder(holder: ReleasedViewHolder, position: Int) {
        holder.bind(releasedPatientsList.get(position))
    }

    fun setReleasedPatientsList(newList: List<Patient>){

        val diffCallBack = PatientDiffCallBack(releasedPatientsList,newList)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        releasedPatientsList.clear()
        releasedPatientsList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}