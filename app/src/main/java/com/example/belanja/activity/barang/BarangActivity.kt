package com.example.belanja.activity.barang

import DataBarangAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.belanja.R
import com.example.belanja.activity.barang.add.AddBarangActivity
import com.example.belanja.base.BaseActivity
import com.example.belanja.model.Barang

class BarangActivity : BaseActivity(), DataBarangView {


    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)
        refreshBarang()

          }
    private fun refreshBarang(){
        DataBarangPresenter(this).getDataBarang(user)
    }

    override fun onSuccessDataBarang(data: List<Barang?>?) {
        findViewById<RecyclerView>(R.id.rvDataBarang).adapter = DataBarangAdapter(data, object : DataBarangAdapter.OnMenuClicked{
            override fun click(menuItem: MenuItem, barang: Barang?){
                when(menuItem.itemId){
                    R.id.editBarang -> editBarang(barang)
                    R.id.hapusBarang -> hapusBarang(barang)

                }
            }
        })
    }

    override fun onErrorDataBarang(msg: String?) {
        println(msg)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun addBarang(){
        findViewById<Button>(R.id.btAddBarang).setOnClickListener {
            val intent = Intent(this, AddBarangActivity::class.java)
            startActivity(intent)
        }

    }

    private fun editBarang(barang: Barang?){

    }

    private fun hapusBarang(barang: Barang?){

    }

    override fun onResume() {
        super.onResume()
        refreshBarang()
    }
}