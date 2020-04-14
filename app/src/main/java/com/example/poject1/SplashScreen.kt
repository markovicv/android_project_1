package com.example.poject1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.poject1.model.MedicalWorker
import com.example.poject1.ui.activities.LoginActivity
import com.example.poject1.ui.activities.MainActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_splash)

        val sharedPreference = getSharedPreferences(packageName, Context.MODE_PRIVATE)
       // sharedPreference.edit().clear().apply()
        val name = sharedPreference.getString("name",null)
        val surname = sharedPreference.getString("surname",null)
        val hospital = sharedPreference.getString("hospital",null)
        val pin = sharedPreference.getInt("PIN",-1)

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
