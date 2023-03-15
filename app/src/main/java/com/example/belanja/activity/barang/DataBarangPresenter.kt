package com.example.belanja.activity.barang

import com.example.belanja.ResultSimple
import com.example.belanja.model.Barang
import com.example.belanja.model.User
import com.example.belanja.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataBarangPresenter(val dataBarangView: DataBarangView) {
    fun getDataBarang(user: User?){
        NetworkConfig.service()
            .getDataBarang(user?.id_user)
            .enqueue(object: Callback<ResultDataBarang> {
                override fun onResponse(call: Call<ResultDataBarang>, response: Response<ResultDataBarang>) {
                    val body = response.body()
                    dataBarangView.onSuccessDataBarang(body?.barang)
                }
                override fun onFailure(call: Call<ResultDataBarang>, t: Throwable) {
                    dataBarangView.onErrorDataBarang(t.localizedMessage)
                }

            })
    }

    fun deleteBarang( barang: Barang?) {
        NetworkConfig.service().hapusBarang(barang?.idBarang).enqueue(object: Callback<ResultSimple>{
            override fun onResponse(call: Call<ResultSimple>, response: Response<ResultSimple>) {
                val body = response.body()
                if(body?.status == "200"){
                    dataBarangView.onSuccessDeleteBarang(body.message)
                } else {
                    dataBarangView.onErrorDeleteBarang(body?.message)
                }

            }
            override fun onFailure(call: Call<ResultSimple>, t: Throwable) {
                dataBarangView.onErrorDataBarang(t.localizedMessage)
            }


        })
    }
}

