package com.example.lletres.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fitInside
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    onClickLletra: (String) -> Unit,
    modifier: Modifier = Modifier) {
    val lletres = ('A'..'Z').toList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
    ) {
        items(lletres) { lletra ->
            Button(onClick = {
                onClickLletra(lletra.toString())
            },
                modifier = Modifier.wrapContentWidth()
            ){
                Text(lletra.toString())
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen({'A'})
}