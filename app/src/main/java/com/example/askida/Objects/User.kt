package com.example.askida.Objects

import com.example.askida.Cart

class User {
    var Name: String = "";
    var Email: String = "";
    var Password: String = "";
    var IsUserMarketPlace: Boolean = false;

    constructor() {
    }

    constructor(name: String, email: String, password: String, isUserMarketPlace: Boolean, ) {
        this.Name = name
        this.Email = email;
        this.Password = password;
        this.IsUserMarketPlace = isUserMarketPlace;
    }
}