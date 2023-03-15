package com.example.belanja.activity.barang.add

import com.example.belanja.model.Barang
import com.example.belanja.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddBarangPresenter (val addBarangView: AddBarangView) {
    fun addBarang(dataBarang: Barang){
        NetworkConfig.service().addBarang(dataBarang.idUser, dataBarang.barcode, dataBarang.namaBarang, dataBarang.kategori, dataBarang.hargaBeli, dataBarang.hargaJual)
            .enqueue(object : Callback<Barang>{
            override fun onResponse(call: Call<Barang>, response: Response<Barang>) {
               val body = response.body()
                addBarangView.onSuccessAddBarang(body?.namaBarang)
            }
            override fun onFailure(call: Call<Barang>, t: Throwable) {
                addBarangView.onErrorAddBarang(t.localizedMessage)
            }

        }
            )
    }

    fun updateBarang(dataBarang: Barang){
        NetworkConfig.service().editBarang(dataBarang.idBarang, dataBarang.idUser, dataBarang.barcode, dataBarang.namaBarang, dataBarang.kategori, dataBarang.hargaBeli, dataBarang.hargaJual)
            .enqueue(object: Callback<Barang>{
                override fun onResponse(call: Call<Barang>, response: Response<Barang>) {
                    val body = response.body()
                    addBarangView.onSuccessAddBarang(body?.namaBarang)
                }

                override fun onFailure(call: Call<Barang>, t: Throwable) {
                  addBarangView.onErrorAddBarang(t.localizedMessage)
                }

            })
    }
}