package com.example.laboratorio3.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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
        //1. Paso
        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        var navView = findViewById<NavigationView>(R.id.navView)
        //2. Paso
        toggle = ActionBarDrawerToggle(this,drawerLayout , R.string.open, R.string.close)
        //3. Paso
        drawerLayout.addDrawerListener(toggle)
        //4. Paso
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.jobAppList -> {val i = Intent(this, ListJobApplication::class.java)
                    startActivity(i)
                }
                R.id.myJobApp -> {
                    Toast.makeText(applicationContext,"Boton clickeado",Toast.LENGTH_SHORT).show()
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