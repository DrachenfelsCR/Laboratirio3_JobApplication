package com.example.laboratorio3.ui

class Aplicante {
    constructor(
        user: String,
        firstName: String,
        lastName: String,
        streetAddresOne: String,
        streetAddresTwo: String,
        city: String,
        province: String,
        zipcode: String,
        country: String,
        email: String,
        areacode: String,
        phone: String,
        applyPosition: String,
        startDate: String,
        foto: Int
    ) {
        this.user = user
        this.firstName = firstName
        this.lastName = lastName
        this.streetAddresOne = streetAddresOne
        this.streetAddresTwo = streetAddresTwo
        this.city = city
        this.province = province
        this.zipcode = zipcode
        this.country = country
        this.email = email
        this.areacode = areacode
        this.phone = phone
        this.applyPosition = applyPosition
        this.startDate = startDate
        this.foto = foto
    }


    var user:String = ""
    var firstName:String = ""
    var lastName:String = ""
    var streetAddresOne:String = ""
    var streetAddresTwo:String = ""
    var city:String = ""
    var province:String = ""
    var zipcode:String = ""
    var country:String = ""
    var email:String = ""
    var areacode:String = ""
    var phone:String = ""
    var applyPosition:String = ""
    var startDate:String = ""
    var foto:Int = 0
}