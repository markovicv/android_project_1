package com.example.poject1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MedicalWorker(var name:String,var surname:String,var hospital:String,var pin:Int) :Parcelable {
}