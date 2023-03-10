package com.example.belanja.activity.barang

import com.example.belanja.model.Barang

interface DataBarangView {
    fun onSuccessDataBarang(data: List<Barang?>?)
    fun onErrorDataBarang(msg: String?)
}