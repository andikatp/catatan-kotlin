package com.example.belanja.activity.login

import com.example.belanja.model.User
import com.google.gson.annotations.SerializedName

data class ResultLogin(

	@field:SerializedName("Status")
	val status: String? = null,

	@field:SerializedName("User")
	val user: User? = null,

	@field:SerializedName("Message")
	val message: String? = null
)