package com.example.belanja.model

import com.google.gson.annotations.SerializedName

data class Barang(
	@field:SerializedName("id_barang")
	val idBarang: String? = null,

	@field:SerializedName("harga_beli")
	val hargaBeli: String? = null,

	@field:SerializedName("nama_barang")
	val namaBarang: String? = null,

	@field:SerializedName("kategori")
	val kategori: String? = null,

	@field:SerializedName("id_user")
	val idUser: Int? = null,

	@field:SerializedName("stok")
	val stok: String? = null,

	@field:SerializedName("created_date")
	val createdDate: String? = null,

	@field:SerializedName("harga_jual")
	val hargaJual: String? = null,

	@field:SerializedName("barcode")
	val barcode: String? = null
)