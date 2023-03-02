package com.example.belanja.utils

import java.text.NumberFormat
import java.util.Locale

object Uang {
    fun indonesia(uang:Double): String {
        val localeId = Locale("in","id")
        val kursId:NumberFormat = NumberFormat.getCurrencyInstance(localeId)

        return kursId.format(uang)
    }

}