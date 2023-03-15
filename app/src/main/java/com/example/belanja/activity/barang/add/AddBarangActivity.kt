package com.example.belanja.activity.barang.add

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.belanja.R
import com.example.belanja.base.BaseActivity
import com.example.belanja.model.Barang
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

class AddBarangActivity : BaseActivity(), AddBarangView {
    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_barang)
            
        val intent = intent.getSerializableExtra(TAGS.BARANG)


        if(intent != null){
            setActionEditButton(intent)
        } else {
            setActionTambahButton()
        }
    }
    
    private  fun setActionEditButton(serializable: Serializable){
        findViewById<Button>(R.id.btAddBarang).text = "Simpan"
        val barang = serializable as Barang
        findViewById<EditText>(R.id.etAddBarangBarcode).setText(barang.barcode)
        findViewById<EditText>(R.id.etAddBarangNamaBarang).setText(barang.namaBarang)
        findViewById<EditText>(R.id.etAddBarangKategori).setText(barang.kategori)
        findViewById<EditText>(R.id.etAddBarangHargaBeli).setText(barang.hargaBeli.toString())
        findViewById<EditText>(R.id.etAddBarangHargaJual).setText(barang.hargaJual.toString())

        findViewById<Button>(R.id.btAddBarang).setOnClickListener {
            val barcode = findViewById<EditText>(R.id.etAddBarangBarcode).text.toString()
            val namaBarang =  findViewById<EditText>(R.id.etAddBarangNamaBarang).text.toString()
            val kategori =  findViewById<EditText>(R.id.etAddBarangKategori).text.toString()
            val hargaBeli = findViewById<EditText>(R.id.etAddBarangHargaBeli).text.toString()
            val hargaJual =  findViewById<EditText>(R.id.etAddBarangHargaJual).text.toString()

            if(hargaBeli.isNotBlank() && hargaJual.isNotBlank()){
                val harga_beli = hargaBeli.toDouble()
                val harga_jual = hargaJual.toDouble()

                barang.idUser = user?.id_user
                barang.barcode = barcode
                barang.namaBarang = namaBarang.uppercase()
                barang.kategori = kategori.lowercase().capitalize()
                barang.hargaBeli = harga_beli
                barang.hargaJual = harga_jual

                AddBarangPresenter(this).updateBarang(barang)
            } else {
                Snackbar.make(it, "Harga tidak boleh kosong", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun setActionTambahButton() {
        findViewById<Button>(R.id.btAddBarang).setOnClickListener {
            findViewById<Button>(R.id.btAddBarang).text = "Tambah"
            val barcode = findViewById<EditText>(R.id.etAddBarangBarcode).text.toString()
            val nama_barang = findViewById<EditText>(R.id.etAddBarangNamaBarang).text.toString()
            val kategori = findViewById<EditText>(R.id.etAddBarangKategori).text.toString()
            val harga_beli_s = findViewById<EditText>(R.id.etAddBarangHargaBeli).text.toString()
            val harga_jual_s = findViewById<EditText>(R.id.etAddBarangHargaJual).text.toString()

            if (harga_beli_s.isNotBlank() && harga_jual_s.isNotBlank()) {
                val harga_beli = harga_beli_s.toDouble()
                val harga_jual = harga_jual_s.toDouble()

                val barang = Barang()
                barang.idUser = user?.id_user
                barang.barcode = barcode
                barang.namaBarang = nama_barang
                barang.kategori = kategori
                barang.hargaBeli = harga_beli
                barang.hargaJual = harga_jual
                AddBarangPresenter(this@AddBarangActivity).addBarang(barang)
            } else {
                Snackbar.make(it, "Harga tidak boleh kosong", Snackbar.LENGTH_LONG).show()
            }

        }

    }

    override fun onSuccessAddBarang(msg: String?) {
        Toast.makeText(this, "Barang Berhasil Dimasukkan", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onErrorAddBarang(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}