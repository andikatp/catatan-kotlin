package com.example.belanja

import com.google.gson.annotations.SerializedName

data class ResultSimple(

    @field:SerializedName("Status")
    val status: String? = null,

    @field:SerializedName("Message")
    val message: String? = null
)
