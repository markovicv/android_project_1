package com.example.poject1.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.poject1.Konstants
import com.example.poject1.R
import com.example.poject1.model.MedicalWorker
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.layout_pin_dialog.*
import kotlinx.android.synthetic.main.layout_pin_dialog.view.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editor = getSharedPreferences(packageName, Context.MODE_PRIVATE).edit()
        var myPin:Int = -1

        pinBtn.setOnClickListener {
            val myCustomDialog = LayoutInflater.from(this).inflate(R.layout.layout_pin_dialog,null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(myCustomDialog)
                .setTitle("PIN")
                .show()

            myCustomDialog.odustaniBtn.setOnClickListener {
                mBuilder.dismiss()
            }
            myCustomDialog.potvrdiBtn.setOnClickListener{
                val pinTyped:String = myCustomDialog.pinET.text.toString()
                if(pinTyped==""){
                    Toast.makeText(this,"Niste uneli pin",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                myPin = Integer.parseInt(pinTyped)
                mBuilder.dismiss()

            }
        }

        prijavaBtn.setOnClickListener {
            val name = nameET.text.toString()
            val surname = surnameET.text.toString()
            val hospital = hospitalET.text.toString()

            if(name =="" || surname=="" || hospital==""){
                Toast.makeText(this,"Niste lepo uneli podatke o vama",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(myPin!=Konstants.LOGIN_PIN){
                Toast.makeText(this,"PIN nije lepo unet",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            editor.putString("name",name)
            editor.putString("surname",surname)
            editor.putString("hospital",hospital)
            editor.putInt("PIN",myPin)
            editor.apply()
            val medicalWorker = MedicalWorker(name,surname,hospital,myPin)
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra(Konstants.MED_PERSON,medicalWorker)

            startActivity(intent)
            finish()


        }



    }
}