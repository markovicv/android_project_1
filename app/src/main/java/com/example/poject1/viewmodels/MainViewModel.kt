package com.example.poject1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poject1.model.Patient

class MainViewModel :ViewModel(){
    private val waitingPatients: MutableLiveData<List<Patient>> = MutableLiveData()
    private val waitingPatientsList:MutableList<Patient> = mutableListOf()

    private val patientsInWaitingRoom:MutableLiveData<Int> = MutableLiveData()

    init{
        patientsInWaitingRoom.value = 0
    }

    fun getPatientsInWaitingRoom():LiveData<Int>{
        return patientsInWaitingRoom
    }
    fun increasePatientsInWaitingRoom(){
        var patients:Int? = patientsInWaitingRoom.value
        patients = patients?.plus(1)
        patientsInWaitingRoom.value = patients
    }
    fun addPatientsToWaiting(patient: Patient){
        waitingPatientsList.add(patient)
        waitingPatients.value = waitingPatientsList
    }







}