package com.example.serveisimple

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.serveisimple.ui.HomeScreen
import com.example.serveisimple.ui.theme.ServeiSimpleTheme

@Composable
fun MainApp() {
    val context = LocalContext.current

    Surface {
        // Centrem la UI a la pantalla
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Mostrem la UI del servei
            HomeScreen(onStart = {
                context.startService(
                    Intent(
                        context,
                        MusicPlaybackService::class.java
                    ).setAction(MusicPlaybackService.MUSICA_RINGTONE)
                )
            }, onStop = {
                context.stopService(
                    Intent(
                        context, MusicPlaybackService::class.java
                    )
                )
            })
        }
    }
}


@Composable
@Preview(showBackground = true)
fun MainPreview() {
    ServeiSimpleTheme {
        MainApp()
    }
}
