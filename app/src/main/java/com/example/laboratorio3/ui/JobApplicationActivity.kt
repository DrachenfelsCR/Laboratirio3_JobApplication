package com.example.laboratorio3.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.laboratorio3.R

class JobApplicationActivity : AppCompatActivity() {

    private fun pickImage(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForResult.launch(intent)
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            // Handle the Intent
            //var ivFotoUpload = findViewById<ImageView>(R.id.ivFotoUpload)
           // ivFotoUpload.setImageURI(result.data?.data)
            //do stuff here
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val user = intent.getStringExtra("USER_EXTRA")
        val pos = intent.getIntExtra("EXTRA_POSITION",-1)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_application)
        val aplicantes:Aplicantes = Aplicantes.instance

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etStreetAddress1 = findViewById<EditText>(R.id.etStreetAddress1)
        val etStreetAddress2 =  findViewById<EditText>(R.id.etStreetAddress2)
        val etCity = findViewById<EditText>(R.id.etCity)
        val etStateProvince = findViewById<EditText>(R.id.etStateProvince)
        val etPostalZip = findViewById<EditText>(R.id.etPostalZip)
        val etCountry = findViewById<EditText>(R.id.etCountry)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etAreaCode = findViewById<EditText>(R.id.etAreaCode)
        val etPhoneNumber = findViewById<EditText>(R.id.etPhoneNumber)
        val etAplyPosition = findViewById<EditText>(R.id.etAplyPosition)
        val etStartDate = findViewById<EditText>(R.id.etStartDate)

        val btnSubmitJobApp = findViewById<Button>(R.id.btnSubmitJobApp)
        val btnJobAppReturn = findViewById<Button>(R.id.btnJobAppReturn)
       // val btnUploadFoto = findViewById<Button>(R.id.btnUploadFoto)



        if (aplicantes.userExist(user.toString())){
           val u = aplicantes.getAplicanteByUser(user.toString())
            etFirstName.setText(u?.firstName)
            etLastName.setText(u?.lastName)
            etStreetAddress1.setText(u?.streetAddresOne)
            etStreetAddress2.setText(u?.streetAddresTwo)
            etCity.setText(u?.city)
            etStateProvince.setText(u?.province)
            etPostalZip.setText(u?.zipcode)
            etCountry.setText(u?.country)
            etEmail.setText(u?.email)
            etAreaCode.setText(u?.areacode)
            etPhoneNumber.setText(u?.phone)
            etAplyPosition.setText(u?.applyPosition)
            etStartDate.setText(u?.startDate)
        }

        /*btnUploadFoto.setOnClickListener {
            pickImage()
        }*/
        btnJobAppReturn.setOnClickListener{
                finish()
        }
        btnSubmitJobApp.setOnClickListener{
           // var ivFotoUpload = findViewById<ImageView>(R.id.ivFotoUpload)
            if (aplicantes.userExist(user.toString())){
                if (pos == -1){
                    aplicantes.editAplicante(Aplicante(user.toString(),etFirstName.text.toString(), etLastName.text.toString(), etStreetAddress1.text.toString(),
                        etStreetAddress2.text.toString(), etCity.text.toString(), etStateProvince.text.toString(),  etPostalZip.text.toString(),
                        etCountry.text.toString(), etEmail.text.toString(), etAreaCode.text.toString(), etPhoneNumber.text.toString(),
                        etAplyPosition.text.toString(), etStartDate.text.toString(),  R.drawable.user))
                    Toast.makeText(applicationContext,"Editado con exito!", Toast.LENGTH_SHORT).show()
                }
                else{
                    aplicantes.editAplicantePos(Aplicante(user.toString(),etFirstName.text.toString(), etLastName.text.toString(), etStreetAddress1.text.toString(),
                        etStreetAddress2.text.toString(), etCity.text.toString(), etStateProvince.text.toString(),  etPostalZip.text.toString(),
                        etCountry.text.toString(), etEmail.text.toString(), etAreaCode.text.toString(), etPhoneNumber.text.toString(),
                        etAplyPosition.text.toString(), etStartDate.text.toString(),  R.drawable.user),pos)
                    Toast.makeText(applicationContext,"Editado con exito!", Toast.LENGTH_SHORT).show()
                }
            }else{

            aplicantes. addAplicante(Aplicante(user.toString(),etFirstName.text.toString(), etLastName.text.toString(), etStreetAddress1.text.toString(),
                etStreetAddress2.text.toString(), etCity.text.toString(), etStateProvince.text.toString(),  etPostalZip.text.toString(),
                etCountry.text.toString(), etEmail.text.toString(), etAreaCode.text.toString(), etPhoneNumber.text.toString(),
                etAplyPosition.text.toString(), etStartDate.text.toString(),  R.drawable.user))
            Toast.makeText(applicationContext,"Agregado con exito!", Toast.LENGTH_SHORT).show()
            finish()
            }
        }
    }
}