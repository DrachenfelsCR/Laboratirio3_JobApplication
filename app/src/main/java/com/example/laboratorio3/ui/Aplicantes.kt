package com.example.laboratorio3.ui

import com.example.laboratorio3.R

class Aplicantes private constructor() {

    private var aplicantes: ArrayList<Aplicante> = ArrayList<Aplicante>()

    init{
        addAplicante(Aplicante("willyrex","Guillermo", "Diaz", "Avenida 44", "NA", "Escaldas",
            "Las Escaldas",  "AD700", "Andorra", "willyrex@gmail.com", "+376", "5233-2255",
            "Host", "5/6/2020",  R.drawable.willy))
        addAplicante(Aplicante("faker","Lee", "Sang-Hyeok", "Avenida 2", "NA", "Gangseo District",
            "Seoul",  "07500", "Korea", "faker@gmail.com", "+82", "1908-2014",
            "ProPlayer", "20/7/2020",   R.drawable.faker))
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

    fun getAplicante(firstName: String?, lastName: String?): Aplicante? {
        for (a: Aplicante in aplicantes!!){
            if(a.firstName.equals(firstName) && a.lastName.equals(lastName)){
                return a;
            }
        }
        return null;
    }

    fun getAplicanteByUser(user: String?): Aplicante? {
        for (a: Aplicante in aplicantes!!){
            if(a.user.equals(user)){
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

    fun editAplicantePos(a: Aplicante, position: Int){
        var aux = aplicantes!!.get(position)
        aux.firstName = a.firstName
        aux.lastName = a.lastName
        aux.streetAddresOne = a.streetAddresOne
        aux.streetAddresTwo = a.streetAddresTwo
        aux.city = a.city
        aux.province = a.province
        aux.zipcode = a.zipcode
        aux.country = a.country
        aux.email = a.email
        aux.areacode = a.areacode
        aux.phone = a.phone
        aux.applyPosition = a.applyPosition
        aux.startDate = a.startDate
        aux.foto = a.foto
    }

    fun editAplicante(aplicante: Aplicante){
        for(a: Aplicante in aplicantes!!){
            if (a.user == aplicante.user){
                a.user = aplicante.user
                a.firstName = aplicante.firstName
                a.lastName = aplicante.lastName
                a.streetAddresOne = aplicante.streetAddresOne
                a.streetAddresTwo = aplicante.streetAddresTwo
                a.city = aplicante.city
                a.province = aplicante.province
                a.zipcode = aplicante.zipcode
                a.country = aplicante.country
                a.email = aplicante.email
                a.areacode = aplicante.areacode
                a.phone = aplicante.phone
                a.applyPosition = aplicante.applyPosition
                a.startDate = aplicante.startDate
                a.foto = aplicante.foto
                break
            }
        }
    }


    fun loginP(firstName: String?, lastName: String?): Aplicante?{
        for(a: Aplicante in aplicantes!!){
            if(a.firstName.equals(firstName) && a.lastName.equals(lastName)){
                return a
            }
        }
        return null
    }

    fun userExist (user: String): Boolean{
        for(a: Aplicante in aplicantes!!){
            if(a.user.equals(user)){
                return true
            }
        }
        return false
    }
}