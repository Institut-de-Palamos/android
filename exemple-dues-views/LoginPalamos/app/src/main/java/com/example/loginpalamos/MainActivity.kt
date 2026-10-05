package com.example.loginpalamos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginpalamos.ui.HorariScreen
import com.example.loginpalamos.ui.LoginScreen
import com.example.loginpalamos.ui.theme.LoginPalamosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPalamosTheme {
                SimpleSwitcherApp()
            }
        }
    }
}

@Composable
fun SimpleSwitcherApp() {
    var currentScreen by remember { mutableStateOf("login") }

    when (currentScreen) {
        "login" -> LoginScreen(
            onLoginSuccess = { currentScreen = "horari" }
        )
        "horari" -> HorariScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleSwitcherAppPreview() {
    SimpleSwitcherApp()
}
