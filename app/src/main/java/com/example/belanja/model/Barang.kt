package com.example.belanja.model

import com.google.gson.annotations.SerializedName

data class Barang(
	@field:SerializedName("id_barang")
	var idBarang: Int? = null,

	@field:SerializedName("hargaB")
	var hargaBeli: Double? = null,

	@field:SerializedName("nama")
	var namaBarang: String? = null,

	@field:SerializedName("kategori")
	var kategori: String? = null,

	@field:SerializedName("user")
	var idUser: Int? = null,

	@field:SerializedName("created_date")
	var createdDate: String? = null,

	@field:SerializedName("hargaJ")
	var hargaJual: Double? = null,

	@field:SerializedName("barcode")
	var barcode: String? = null
)