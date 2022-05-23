package com.example.laboratorio3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.laboratorio3.R

class PasswordChangeActivity : AppCompatActivity() {
    var logins: Logins = Logins.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        val etNewPassword = findViewById<EditText>(R.id.etNewPassword)
        val btnNewPassSubmit = findViewById<Button>(R.id.btnNewPassSubmit)
        val btnNewPassReturn = findViewById<Button>(R.id.btnNewPassReturn)
        val user = intent.getStringExtra("USER_EXTRA")

        btnNewPassReturn.setOnClickListener{
            finish()
        }

        btnNewPassSubmit.setOnClickListener {
            if (etNewPassword.text.isEmpty()){
                Toast.makeText(applicationContext,"Password is empty!", Toast.LENGTH_SHORT).show()
            }else{
                if (user != null) {
                    logins.passChange(user,etNewPassword.text.toString())
                    Toast.makeText(applicationContext,"Password Changed Successfully :)", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}