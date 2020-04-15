package com.example.poject1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poject1.model.MedicalWorker

class ProfileViewModel : ViewModel() {

    private var medicalWorker : MutableLiveData<MedicalWorker> = MutableLiveData()


    fun setMedicalWorker(medicalWorker: MedicalWorker){
        this.medicalWorker.value = medicalWorker
    }

    fun getMedicalWorker():LiveData<MedicalWorker>{
        return medicalWorker
    }
}