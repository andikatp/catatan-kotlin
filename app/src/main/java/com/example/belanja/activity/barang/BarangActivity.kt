package com.example.belanja.activity.barang

import DataBarangAdapter
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.belanja.R
import com.example.belanja.activity.barang.add.AddBarangActivity
import com.example.belanja.base.BaseActivity
import com.example.belanja.model.Barang
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BarangActivity : BaseActivity(), DataBarangView {


    override fun onCreate(savedInstanceState: Bundle?) {
        cekSesi(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barang)
        refreshBarang()
        addBarang()
    }

    private fun refreshBarang() {
        DataBarangPresenter(this@BarangActivity).getDataBarang(user)
    }

    override fun onSuccessDataBarang(data: List<Barang?>?) {
        findViewById<RecyclerView>(R.id.rvDataBarang).adapter =
            DataBarangAdapter(data, object : DataBarangAdapter.OnMenuClicked {
                override fun click(menuItem: MenuItem, barang: Barang?) {
                    when (menuItem.itemId) {
                        R.id.editBarang -> editBarang(barang)
                        R.id.hapusBarang -> hapusBarang(barang)

                    }
                }
            }
            )
    }

    override fun onErrorDataBarang(msg: String?) {
        println(msg)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessDeleteBarang(msg: String?) {
        Toast.makeText(this, "Berhasil menghapus barang", Toast.LENGTH_SHORT).show()
        refreshBarang()
    }

    override fun onErrorDeleteBarang(msg: String?) {
        Toast.makeText(this, "gagal menghapus barang", Toast.LENGTH_SHORT).show()
    }

    private fun addBarang() {
        findViewById<FloatingActionButton>(R.id.btAddDataBarang).setOnClickListener {
            val intent = Intent(this, AddBarangActivity::class.java).apply {
                putExtra(TAGS.USER, user)
            }
            startActivity(intent)
        }

    }

    private fun editBarang(barang: Barang?) {
        val intent = Intent(this, AddBarangActivity::class.java).apply {
            putExtra(TAGS.USER, user)
            putExtra(TAGS.BARANG, barang)
        }
        startActivityForResult(intent, 1)
    }

    private fun hapusBarang(barang: Barang?) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Anda Yakin Untuk Menghapus Data?")
        builder.setMessage("Anda akan menghapus data ${barang?.namaBarang}! apakah anda yakin?")
        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                "Hapus", Toast.LENGTH_SHORT).show()
            DataBarangPresenter(this).deleteBarang(barang)
        }
        builder.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(applicationContext,
                "Batal", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

    override fun onResume() {
        super.onResume()
        refreshBarang()
    }
}