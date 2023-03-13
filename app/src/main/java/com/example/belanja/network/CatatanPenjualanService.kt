package com.example.belanja.network


import com.example.belanja.activity.barang.ResultDataBarang
import com.example.belanja.activity.login.ResultLogin
import com.example.belanja.model.Barang
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CatatanPenjualanService {
    @FormUrlEncoded
    @POST("user/read.php")
    fun loginUser(
        @Field("username") username: String?,
        @Field("password") password: String?
    ): Call<ResultLogin>

    @FormUrlEncoded
    @POST("barang/read.php")
    fun getDataBarang(@Field("id_user") id_user: Int?): Call<ResultDataBarang>

    @FormUrlEncoded
    @POST("barang/create.php")
    fun addBarang(
        @Field("id_user") id_user: Int?,
        @Field("barcode") barcode: String?,
        @Field("nama_barang") nama_barang: String?,
        @Field("kategori") kategori: String?,
        @Field("harga_beli") harga_beli: Double?,
        @Field("harga_jual") harga_jual: Double?
    ): Call<Barang>
}