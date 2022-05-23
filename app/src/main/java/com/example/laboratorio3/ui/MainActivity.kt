package com.example.laboratorio3.ui

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.laboratorio3.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = intent.getSerializableExtra("Login") as Login
        //1. Paso
        var tvLoggedUser= findViewById<TextView>(R.id.tvLoggedUser)
        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        var navView = findViewById<NavigationView>(R.id.navView)
        var btnLogout = findViewById<Button>(R.id.btnLogout)
        var myJobApp = findViewById<Button>(R.id.myJobApp)
        var jobAppList = findViewById<Button>(R.id.jobAppList)

        tvLoggedUser.text = user.user
        //2. Paso
        toggle = ActionBarDrawerToggle(this,drawerLayout , R.string.open, R.string.close)
        //3. Paso
        drawerLayout.addDrawerListener(toggle)
        //4. Paso
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnLogout.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            finish()
            startActivity(i)
        }

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.jobAppList -> {
                    if(user.rol.equals("Admin")){
                        val i = Intent(this, ListJobApplication::class.java)
                        i.putExtra("USER_EXTRA",user?.user!!)
                        startActivity(i)
                    }else{
                        Toast.makeText(applicationContext,"Option only for admind!", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.myJobApp -> {
                    if(user.rol.equals("Aplicante")){
                        val i = Intent(this, JobApplicationActivity::class.java)
                        i.putExtra("USER_EXTRA",user?.user!!)
                        startActivity(i)
                    }else{
                        Toast.makeText(applicationContext,"Option only for applicants", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.passchange -> {
                    val i = Intent(this, PasswordChangeActivity::class.java)
                    i.putExtra("USER_EXTRA",user?.user!!)
                    startActivity(i)
                }
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}