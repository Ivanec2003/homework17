package com.example.homework17

import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
    fun clickButtonConfirm(login: String, password: String): Boolean{
        return login.isNotEmpty() && password.isNotEmpty()
    }
}