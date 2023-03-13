package com.example.belanja

import MenuAdapter
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.belanja.activity.barang.BarangActivity
import com.example.belanja.activity.penjualan.PenjualanActivity
import com.example.belanja.base.BaseActivity
import com.example.belanja.model.Barang

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initActionButton()
        findViewById<TextView>(R.id.tvWelcome).text = "Welcome ${user?.username}"
    }

    private fun initActionButton() {
        findViewById<RecyclerView>(R.id.mainMenu).adapter =
            MenuAdapter(object : MenuAdapter.OnMenuClick {
                override fun onClick(image: Int) {
                    when (image) {
                        R.drawable.ic_goods -> openDataBarang()
                        R.drawable.ic_shopping_cart -> openDataPenjualan()
                    }
                }
            }
            )
    }

    private fun openDataBarang() {
        val intent = Intent(this, BarangActivity::class.java).apply {
          putExtra(TAGS.USER, user)
        }
             startActivity(intent)
    }

    private fun openDataPenjualan() {
        val intent = Intent(this, PenjualanActivity::class.java).apply {
            putExtra(TAGS.USER, user)
        }

              startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

        return super.onOptionsItemSelected(item)
    }

}