package com.example.belanja.network


import com.example.belanja.ResultSimple
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
        @Field("user") id_user: Int?,
        @Field("barcode") barcode: String?,
        @Field("nama") namaBarang: String?,
        @Field("kategori") kategori: String?,
        @Field("hargaB") hargaBeli: Double?,
        @Field("hargaJ") hargaJual: Double?
    ): Call<Barang>

   @FormUrlEncoded
   @POST("barang/edit.php")
   fun editBarang(
       @Field("id") id_barang: Int?,
       @Field("user") id_user: Int?,
       @Field("barcode") barcode: String?,
       @Field("nama") nama_barang: String?,
       @Field("kategori") kategori: String?,
       @Field("hargaB") hargaBeli: Double?,
       @Field("hargaJ") hargaJual: Double?
   ): Call<Barang>

   @FormUrlEncoded
   @POST("barang/delete.php")
   fun hapusBarang(
       @Field("id") id_barang: Int?
   ): Call<ResultSimple>
}