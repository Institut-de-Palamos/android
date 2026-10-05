package com.example.loginpalamos

import androidx.annotation.DrawableRes

data class ClasseItem(
    val hora: String,
    val assignatura: String,
    @param:DrawableRes val iconaRes: Int,
    val aula: String = "",
    val professor: String = "",
    val tasquesPendents: Int = 0,
    val esLliure: Boolean = false
)
