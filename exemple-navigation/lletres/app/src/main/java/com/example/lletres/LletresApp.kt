package com.example.lletres

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.lletres.navigation.AppNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LletresApp() {
    Scaffold(
        topBar = {
            LletresTopAppBar()
        }
    ) {
        val navController = rememberNavController()
        AppNavigation(
            navController,
            modifier = Modifier.padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LletresTopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Lletres",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    )
}

@Preview(showBackground = true)
@Composable()
fun LletresAppPreview() {
    LletresApp()
}