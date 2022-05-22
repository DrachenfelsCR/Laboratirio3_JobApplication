package com.example.laboratorio3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.laboratorio3.R

class LoginActivity : AppCompatActivity() {

    var logins: Logins = Logins.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var etLoginNombre = findViewById<EditText>(R.id.etLoginNombre)
        var etPassword = findViewById<EditText>(R.id.etPassword)
        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var btnClear = findViewById<Button>(R.id.btnClear)

        btnClear.setOnClickListener {
            // clearing user_name and password edit text views on reset button click
            etLoginNombre.setText("")
            etPassword.setText("")
        }

        btnLogin.setOnClickListener {
            val user_name = etLoginNombre.text;
            val password = etPassword.text;
            if(logins.login(user_name.toString(), password.toString())){
                val bundle = Bundle()
                val LoginS = logins.loginP(user_name.toString(), password.toString())
                val i = Intent(this, ListJobApplication::class.java)
                i.putExtra("msg", "MENSAJE DE Login al Menú")
                i.putExtra("Login", LoginS)
//            i.putExtra("passw", password.toString())
                // start your next activity
                startActivity(i)
                // your code to validate the user_name and password combination
                // and verify the same
            }else{
                Toast.makeText(this, "El usuario no se encuentra registrado", Toast.LENGTH_SHORT).show()
            }

        }




    }
}