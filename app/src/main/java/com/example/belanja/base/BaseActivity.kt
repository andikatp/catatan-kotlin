package com.example.belanja.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.example.belanja.model.User

@Suppress("DEPRECATION")
@SuppressLint("Registered")
open class BaseActivity {
    object TAGS{
        val BARANG = "barang"
        val USER = "user"
    }

    var user: User?=null

    fun cekSesi(activity: Activity){
        val intent = activity.intent.getSerializableExtra("name")

        if(intent == null)
        {
            Toast.makeText(activity, "Anda Belum Login", Toast.LENGTH_SHORT )
            activity.finish()
        } else {
            user = intent as User
        }
    }
}