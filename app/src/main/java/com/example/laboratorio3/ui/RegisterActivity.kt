package com.example.laboratorio3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.laboratorio3.R

class RegisterActivity : AppCompatActivity() {

    var logins : Logins = Logins.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var etRegisterName = findViewById<EditText>(R.id.etRegisterName)
        var etRegisterPassword = findViewById<EditText>(R.id.etRegisterName)

        var btnSubmitRegister = findViewById<Button>(R.id.btnSubmitRegister)
        var btnRegisterReturn = findViewById<Button>(R.id.btnRegisterReturn)
        var cbAdmin = findViewById<CheckBox>(R.id.cbAdmin)

        btnRegisterReturn.setOnClickListener{
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        btnSubmitRegister.setOnClickListener{
            if (etRegisterName.text.toString().equals("") || etRegisterPassword.text.toString().equals("")){
                Toast.makeText(applicationContext,"Hay espacios sin llenar", Toast.LENGTH_SHORT).show()

            }else{
              if (logins.userExist(etRegisterName.text.toString())){
                  Toast.makeText(applicationContext,"Este usuario ya existe", Toast.LENGTH_SHORT).show()
              }else{
                  if (cbAdmin.isChecked){
                      logins.addPLogin(Login(etRegisterName.text.toString(),etRegisterPassword.text.toString(),"Admin" ))
                      val i = Intent(this, MainActivity::class.java)
                      i.putExtra("Login", Login(etRegisterName.text.toString(),etRegisterPassword.text.toString(),"Admin"))
                      startActivity(i)
                  }
                  else{
                      logins.addPLogin(Login(etRegisterName.text.toString(),etRegisterPassword.text.toString(),"Aplicante" ))
                      val i = Intent(this, MainActivity::class.java)
                      i.putExtra("Login", Login(etRegisterName.text.toString(),etRegisterPassword.text.toString(),"Aplicante"))
                      startActivity(i)
                  }
              }
            }

        }



    }
}