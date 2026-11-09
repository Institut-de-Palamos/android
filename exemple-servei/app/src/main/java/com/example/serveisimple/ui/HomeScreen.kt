package com.example.serveisimple.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onStart: () -> Unit,
    onStop: () -> Unit,
    modifier: Modifier = Modifier
) {

    // Estat del servei i el valor del botó.
    val serviceStatus = remember {
        mutableStateOf(false)
    }
    val buttonValue = remember {
        mutableStateOf("Start Service")
    }


    // Botó START/STOP
    Button(modifier = modifier, onClick = {
        if (serviceStatus.value) {
            // Si el servei ja s'està executant -> aturem el servei
            serviceStatus.value = !serviceStatus.value
            buttonValue.value = "Start"
            onStop()

        } else {
            // Si el servei no s'està executant -> l'iniciem.
            serviceStatus.value = !serviceStatus.value
            buttonValue.value = "Stop"

            // Iniciem el servei
            onStart()
        }

    }) {
        Text(
            text = buttonValue.value,
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            fontSize = 20.sp
        )
    }
}
