package com.example.belanja.base


import android.app.Activity
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.belanja.model.User



@Suppress("DEPRECATION")
open class BaseActivity  : AppCompatActivity(){
    object TAGS{
        val BARANG = "barang"
        val USER = "user"
    }

    var user: User?=null




    fun cekSesi(activity: Activity){
        val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            activity.intent.getSerializableExtra("user", User::class.java)
        } else {
            activity.intent.getSerializableExtra("user")
        }

        if(intent == null)
        {
            Toast.makeText(activity, "Anda Belum Login", Toast.LENGTH_SHORT )
            activity.finish()
        } else {
            user = intent as User
        }
    }
}