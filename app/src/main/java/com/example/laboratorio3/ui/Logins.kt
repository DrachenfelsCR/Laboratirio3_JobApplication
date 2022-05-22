package com.example.laboratorio3.ui

import android.util.Log
import com.example.laboratorio3.R

class Logins private constructor() {

    private var logins: ArrayList<Login> = ArrayList<Login>()


    init{
        addPLogin(Login("willyrex", "123", "Aplicante"))
        addPLogin(Login("faker", "123", "Admin"))
    }

    private object HOLDER {
        val INSTANCE = Logins()
    }

    companion object {
        val instance: Logins by lazy {
            HOLDER.INSTANCE
        }
    }

    fun addPLogin(login: Login){
        logins?.add(login)
    }

    fun userExist (user: String): Boolean{
        for(l: Login in logins!!){
            if(l.user.equals(user)){
                return true
            }
        }
        return false
    }

    fun login(user: String?, password: String?): Boolean{
        for(l: Login in logins!!){
            if(l.user.equals(user) && l.password.equals(password)){
                return true
            }
        }
        return false
    }
    fun loginP(user: String?, password: String?): Login?{
        for(p: Login in logins!!){
            if(p.user.equals(user) && p.password.equals(password)){
                return p
            }
        }
        return null
    }

    fun getLogin(user: String): Login? {
        for (l: Login in logins!!){
            if(l.user.equals(user)){
                return l;
            }
        }
        return null;
    }
}