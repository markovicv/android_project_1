package com.example.poject1.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.poject1.Konstants
import com.example.poject1.R
import com.example.poject1.model.MedicalWorker
import com.example.poject1.ui.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.layout_pin_dialog.*

class EditProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val medicalWorker = intent.getParcelableExtra(Konstants.MED_PERSON) as MedicalWorker
        nameeditET.setText(medicalWorker.name)
        surnameditET.setText(medicalWorker.surname)
        hospitaleditET.setText(medicalWorker.hospital)

        editodustaniBtn.setOnClickListener {
            finish()
        }
        editIzmeniBtn.setOnClickListener {

            val newName = nameeditET.text.toString()
            val newSurname = surnameditET.text.toString()
            val newHospital = hospitaleditET.text.toString()

            if(newName == ""){
                nameeditET.setError(this.resources.getString(R.string.IME_LOSE_UNESENO))
                return@setOnClickListener
            }
            if(newSurname == ""){
                surnameditET.setError(this.resources.getString(R.string.PREZIME_LOSE_UNESENO))
                return@setOnClickListener

            }
            if(newHospital==""){
                hospitaleditET.setError(this.resources.getString(R.string.BOLNICA_LOSE_UNESENO))
                return@setOnClickListener
            }
            medicalWorker.name = newName
            medicalWorker.surname = newSurname
            medicalWorker.hospital = newHospital

            val editor = getSharedPreferences(Konstants.MEDICAL_PREFERENCE, Context.MODE_PRIVATE).edit()
            editor.putString(Konstants.EDITOR_NAME,medicalWorker.name)
            editor.putString(Konstants.EDITOR_SURNAME,medicalWorker.surname)
            editor.putString(Konstants.EDITOR_HOSPITAL,medicalWorker.hospital)
            editor.apply()

            finish()



        }
    }


}