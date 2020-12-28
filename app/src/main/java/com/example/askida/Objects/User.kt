package com.example.askida.Objects

class User {
    var Id:String=""
    var Name: String = "";
    var Email: String = "";
    var Password: String = "";
    var City: String = "";
    var IsUserMarketPlace: Boolean = false;

    constructor()
    constructor(name: String, email: String, password: String, isUserMarketPlace: Boolean,City:String) {
        this.Name = name
        this.Email = email
        this.Password = password
        this.IsUserMarketPlace = isUserMarketPlace
        this.City=City
    }
}