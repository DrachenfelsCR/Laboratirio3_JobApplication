package com.example.laboratorio3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.laboratorio3.R

class JobApplicationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_application)
        var logins:Logins = Logins.instance

        var etFirstName = findViewById<EditText>(R.id.etFirstName)
        var etLastName = findViewById<EditText>(R.id.etLastName)
        var etStreetAddress1 = findViewById<EditText>(R.id.etStreetAddress1)
        var etStreetAddress2 =  findViewById<EditText>(R.id.etStreetAddress2)
        var etCity = findViewById<EditText>(R.id.etCity)
        var etStateProvince = findViewById<EditText>(R.id.etStateProvince)
        var etPostalZip = findViewById<EditText>(R.id.etPostalZip)
        var etCountry = findViewById<EditText>(R.id.etCountry)
        var etEmail = findViewById<EditText>(R.id.etEmail)
        var etAreaCode = findViewById<EditText>(R.id.etAreaCode)
        var etPhoneNumber = findViewById<EditText>(R.id.etPhoneNumber)
        var etAplyPosition = findViewById<EditText>(R.id.etAplyPosition)
        var etStartDate = findViewById<EditText>(R.id.etStartDate)

        var btnSubmitJobApp = findViewById<Button>(R.id.btnSubmitJobApp)
        var btnJobAppReturn = findViewById<Button>(R.id.btnJobAppReturn)

        btnJobAppReturn.setOnClickListener{
                finish()
        }

    }
}