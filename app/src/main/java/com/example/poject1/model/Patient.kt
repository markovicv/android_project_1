package com.example.poject1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Patient(var name:String,var surname:String,var arrivedSimptoms:String,var arrived:String) : Parcelable{
    var currentState:String? = null
    var released:String? = null
    var id:Int? = 0
}