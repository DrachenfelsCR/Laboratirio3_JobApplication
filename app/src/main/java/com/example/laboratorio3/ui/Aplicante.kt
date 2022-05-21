package com.example.laboratorio3.ui

class Aplicante {
    constructor(user: String, password: String, nombre: String, foto: Int) {
        this.user = user
        this.password = password
        this.nombre = nombre
        this.foto = foto
    }

    var user:String = ""
    var password:String = ""
    var nombre:String = ""
    var foto:Int = 0
}