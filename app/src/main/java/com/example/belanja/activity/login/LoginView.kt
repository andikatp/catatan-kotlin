package com.example.belanja.activity.login

import com.example.belanja.model.User

interface LoginView {
    fun onSuccessLogin(user: User?)
    fun onErrorLogin(msg:String?)
}