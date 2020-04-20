package com.example.poject1.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.poject1.Konstants
import com.example.poject1.R
import com.example.poject1.model.MedicalWorker

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_splash)

        val sharedPreference = getSharedPreferences(Konstants.MEDICAL_PREFERENCE, Context.MODE_PRIVATE)
       // sharedPreference.edit().clear().apply()
        val name = sharedPreference.getString(Konstants.EDITOR_NAME,null)
        val surname = sharedPreference.getString(Konstants.EDITOR_SURNAME,null)
        val hospital = sharedPreference.getString(Konstants.EDITOR_HOSPITAL,null)
        val pin = sharedPreference.getInt(Konstants.EDITOR_PIN,-1)

        var isLoged = true

        if(name==null || surname == null || hospital == null || pin == -1){
            isLoged = false
        }
        Handler().postDelayed({
            lateinit var intent: Intent
            if(isLoged){
                val medicalWorker = MedicalWorker(name!!,surname!!,hospital!!,pin)
                intent = Intent(this,MainActivity::class.java)
                intent.putExtra(Konstants.MED_PERSON,medicalWorker)
            }
            else{
                intent = Intent(this,LoginActivity::class.java)
            }
            startActivity(intent)
            finish()

        },3000)
    }
}
