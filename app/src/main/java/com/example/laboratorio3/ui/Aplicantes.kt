package com.example.laboratorio3.ui

import com.example.laboratorio3.R

class Aplicantes private constructor() {

    private var aplicantes: ArrayList<Aplicante> = ArrayList<Aplicante>()

    init{
        addAplicante(Aplicante("willyrex", "123", "Guillermo", R.drawable.willy))
        addAplicante(Aplicante("faker", "123", "Lee Sang-Hyeok", R.drawable.faker))
    }

    private object singletonPersonas {
        val INSTANCE = Aplicantes()
    }
    companion object {
        val instance: Aplicantes by lazy {
            singletonPersonas.INSTANCE
        }
    }
    fun addAplicante(aplicante: Aplicante){
        aplicantes?.add(aplicante)
    }

    fun getAplicante(nombre: String): Aplicante? {
        for (a: Aplicante in aplicantes!!){
            if(a.nombre.equals(nombre)){
                return a;
            }
        }
        return null;
    }

    fun getAplicantes(): ArrayList<Aplicante>{
        return this.aplicantes!!
    }

    fun deleteAplicante(position: Int){
        aplicantes!!.removeAt(position)
    }

    fun editAplicante(a: Aplicante, position: Int){
        var aux = aplicantes!!.get(position)
        aux.password = a.password
        aux.nombre = a.nombre
        aux.user = a.user
    }

    fun loginP(user: String?, password: String?): Aplicante?{
        for(a: Aplicante in aplicantes!!){
            if(a.user.equals(user) && a.password.equals(password)){
                return a
            }
        }
        return null
    }
}