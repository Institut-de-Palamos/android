package com.example.loginpalamos.data.local

import com.example.loginpalamos.ClasseItem
import com.example.loginpalamos.R

object LocalBD {
    fun sampleClasses(): List<ClasseItem>{
        return listOf(
            ClasseItem(
                hora = "08:00 - 09:00",
                assignatura = "Matemàtiques",
                iconaRes = R.drawable.maths,
                aula = "A101",
                professor = "Joan Garcia",
                tasquesPendents = 1
            ),
            ClasseItem(
                hora = "09:00 - 10:00",
                assignatura = "Química",
                iconaRes = R.drawable.chemistry,
                aula = "Lab 2",
                professor = "Maria Soler",
                tasquesPendents = 2
            ),
            ClasseItem(
                hora = "10:00 - 10:30",
                assignatura = "Pati / Esbarjo",
                iconaRes = R.drawable.pati,
                esLliure = true
            ),
            ClasseItem(
                hora = "10:30 - 11:30",
                assignatura = "Literatura",
                iconaRes = R.drawable.books,
                aula = "A203",
                professor = "Carles Pons",
                tasquesPendents = 0
            )
        )
    }
}