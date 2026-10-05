package com.example.loginpalamos.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fitOutside
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpalamos.R

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit = {}) {

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.login_bg),
            contentDescription = null,
            modifier = Modifier.matchParentSize(), // ocupa tot el Box
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1F))
            LoginBody(onLoginSuccess = onLoginSuccess)
            Spacer(modifier = Modifier.weight(1F))
            Text("Tots els drets reservats", fontSize = 12.sp)
        }
    }
}

@Composable
fun FormBody(
    name: String,
    password: String,
    onNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    var mostrarPassword by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Nom d'usuari") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text("Contrasenya") },
            singleLine = true,
            visualTransformation = if (mostrarPassword) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {
                    mostrarPassword = !mostrarPassword
                }) {
                    Icon(
                        painter = painterResource(if (mostrarPassword) R.drawable.eye_hide else R.drawable.eye_show),
                        contentDescription = if (mostrarPassword) "Amaga contrasenya" else "Mostra contrasenya",
                        modifier = Modifier.size(16.dp)

                    )
                }
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
    }
}

@Composable
fun LoginBody(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {}
) {
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var clicks by remember { mutableStateOf(0) }
    val randomNumber = (1..100).random()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Logo()
        MissatgeBenvinguda()
        Spacer(modifier = Modifier.height(40.dp))
        FormBody(
            name, password,
            onNameChange = { name = it },
            onPasswordChange = { password = it },
            Modifier.padding(20.dp),
        )
    }

    if (password.length < 5)
        Text("Contrasenya massa curta", color = Color.Red)

    Row {
        AppButton("Inicia sessió", onClick = {
            Log.d("LoginScreen", "Iniciamt sessió de l'usuari $name amb pass $password")
            onLoginSuccess()
        })
        AppButton("Registra't", onClick = {
            Log.d("LoginScreen", "Has clicat el botó")
            clicks++
            Log.d("LoginScreen", "Clicks: $clicks")
            Log.d("LoginScreen", "Num random: $randomNumber")
        })
    }
    Text("Nombre de clicks $clicks")

    Spacer(modifier = Modifier.height(40.dp))
    Row {
        ExternalLogo(R.drawable.logo_gene)
        ExternalLogo(R.drawable.logo_europa)
        ExternalLogo(R.drawable.logo_clickedu)
    }
}

@Composable
fun MissatgeBenvinguda(modifier: Modifier = Modifier, lloc: String = "InsPalamos") {
    Text(
        "Benvinguts a $lloc",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource((R.color.blau_ins)),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}


@Preview(showBackground = true)
@Composable
fun MissatgeBenvingudaPreview() {
    MissatgeBenvinguda(lloc = "Palamos")
}

@Preview(showBackground = true)
@Composable
fun LoginBodyPreview() {
    LoginBody()
}
