package com.example.belanja.activity.barang

import com.example.belanja.model.Barang
import com.google.gson.annotations.SerializedName

data class ResultDataBarang(
	@field:SerializedName("barang")
	val barang: List<Barang?>? = null
)