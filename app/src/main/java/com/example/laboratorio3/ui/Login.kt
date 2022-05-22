package com.example.laboratorio3.ui

import java.io.Serializable

class Login: Serializable {
    var user: String? = null
    var password: String? = null
    var rol: String? = null

    constructor(user: String?, password: String?, rol: String?) {
        this.user = user
        this.password = password
        this.rol = rol
    }

    fun Login() {
        user = ""
        password = ""
        rol = ""
    }
}
