package com.example.poject1.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.poject1.model.Patient

class MainViewModel :ViewModel(){
    private val waitingPatients: MutableLiveData<List<Patient>> = MutableLiveData()
    private val waitingPatientsList:MutableList<Patient> = mutableListOf()

    private val releasedPatientsList:MutableList<Patient> = mutableListOf()
    private val releasedPatients:MutableLiveData<List<Patient>> = MutableLiveData()

    private val hsopitalizedPatientsList:MutableList<Patient> = mutableListOf()
    private val hospitalizedPatients:MutableLiveData<List<Patient>> = MutableLiveData()

    private val patientsInWaitingRoomNumber:MutableLiveData<Int> = MutableLiveData()
    private val patientHospitalizedNumber :MutableLiveData<Int> = MutableLiveData()
    private val patientsReleasedNumber :MutableLiveData<Int> = MutableLiveData()

    init{
        patientsInWaitingRoomNumber.value = 0
        patientHospitalizedNumber.value=0
        patientsReleasedNumber.value = 0

    }

    fun getNumberOfPatientsInWaitingRoom():LiveData<Int>{
        return patientsInWaitingRoomNumber
    }
    fun getReleasedPatientsNumber():LiveData<Int>{
        return patientsReleasedNumber
    }
    fun getHospitalizedPatientsNumber():LiveData<Int>{
        return patientHospitalizedNumber
    }
    fun getPatientsInWaitingRoom():LiveData<List<Patient>>{
        return waitingPatients
    }
    fun getReleasedPatients():LiveData<List<Patient>>{
        return releasedPatients
    }
    fun getHospitalizedPatients():LiveData<List<Patient>>{
        return hospitalizedPatients
    }

    fun increasePatientsInWaitingRoom(){
        var patients:Int? = patientsInWaitingRoomNumber.value
        patients = patients?.plus(1)
        patientsInWaitingRoomNumber.value = patients
    }
    fun decreasePatientsInWaitingRoom(){
        var patients:Int? = patientsInWaitingRoomNumber.value
        patients = patients?.minus(1)
        patientsInWaitingRoomNumber.value = patients
    }
    fun increasePatientsReleased(){
        var patients:Int? = patientsReleasedNumber.value
        patients = patients?.plus(1)
        patientsReleasedNumber.value = patients
    }
    fun increasePatientsHospitalized(){
        var patients:Int? = patientHospitalizedNumber.value
        patients = patients?.plus(1)
        patientHospitalizedNumber.value = patients
    }
    fun decreasePatientsHospitalized(){
        var patients:Int? = patientHospitalizedNumber.value
        patients = patients?.minus(1)
        patientHospitalizedNumber.value = patients
    }



    fun addPatientsToWaiting(patient: Patient){
        waitingPatientsList.add(patient)
        waitingPatients.value = waitingPatientsList
    }

    fun addPatientsToReleased(patient:Patient){
        releasedPatientsList.add(patient)
        hsopitalizedPatientsList.remove(patient)
        decreasePatientsHospitalized()
        increasePatientsReleased()
        hospitalizedPatients.value = hsopitalizedPatientsList
        releasedPatients.value = releasedPatientsList
    }
    fun addPatientsToHospitalized(patient: Patient){
        hsopitalizedPatientsList.add(patient)
        waitingPatientsList.remove(patient)
        decreasePatientsInWaitingRoom()
        increasePatientsHospitalized()
        waitingPatients.value = waitingPatientsList
        hospitalizedPatients.value = hsopitalizedPatientsList

    }
    fun remowePatientFromWaiting(patient: Patient){
        waitingPatientsList.remove(patient)
        decreasePatientsInWaitingRoom()
        waitingPatients.value = waitingPatientsList
    }

    fun findWaitingPatients(key:String){
        val filterdList = waitingPatientsList.filter {
            it.name.toLowerCase().startsWith(key) || it.surname.toLowerCase().startsWith(key)
        }
        waitingPatients.value = filterdList
    }
    fun findHospitalizedPatients(key:String){
        val filterdList = hsopitalizedPatientsList.filter {
            it.name.toLowerCase().startsWith(key) || it.surname.toLowerCase().startsWith(key)
        }
        hospitalizedPatients.value = filterdList

    }
    fun findReleasedPatients(key:String){
        val filterdList = releasedPatientsList.filter {
            it.name.toLowerCase().startsWith(key) || it.surname.toLowerCase().startsWith(key)
        }
        releasedPatients.value = filterdList

    }
    fun updateRecord(patient: Patient){
        for(i in 0 until hsopitalizedPatientsList.size){
            if(hsopitalizedPatientsList.get(i).id == patient.id){
                hsopitalizedPatientsList.get(i).name = patient.name
                hsopitalizedPatientsList.get(i).surname = patient.surname
                hsopitalizedPatientsList.get(i).arrivedSimptoms = patient.arrivedSimptoms
                hsopitalizedPatientsList.get(i).currentState = patient.currentState
                break
            }
        }
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(hsopitalizedPatientsList)

        hospitalizedPatients.value = listToSubmit
    }







}