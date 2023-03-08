package com.example.belanja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.belanja.activity.login.LoginPresenter
import com.example.belanja.activity.login.LoginView
import com.example.belanja.base.BaseActivity
import com.example.belanja.model.User

class LoginActivity : AppCompatActivity(), LoginView {
    lateinit var etUsername:EditText
    lateinit var etPassword:EditText
    lateinit var btLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById<EditText>(R.id.etLoginUsername)
        etPassword = findViewById<EditText>(R.id.etLoginPassword)
        btLogin = findViewById<Button>(R.id.bLogin)

        initActionButton()

    }
    private fun initActionButton(){
        btLogin.setOnClickListener {
            val user = User()
            user.username = etUsername.text.toString().trim()
            user.password = etPassword.text.toString().trim()

            LoginPresenter(this@LoginActivity).login(user)
        }
    }

     override fun onSuccessLogin(user: User?){
        Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
         val intent = Intent(this, MainActivity::class.java).apply  {
             putExtra(BaseActivity.TAGS.USER, user)

         }
         finish()
         startActivity(intent)
    }

    override fun onErrorLogin(msg: String?){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}