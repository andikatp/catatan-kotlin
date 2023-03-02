package com.example.belanja.model

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class User (
    @field:SerializedName("id_user")
    var id_user:Int?=null,

    @field:SerializedName("username")
    var username:String?=null,

    @field:SerializedName("email")
    var email:String?=null,

    @field:SerializedName("passwword")
    var password:String?=null,

    @field:SerializedName("hp")
    var hp:String?=null,

    @field:SerializedName("create_date")
    var createDate:String?=null,

):java.io.Serializable
