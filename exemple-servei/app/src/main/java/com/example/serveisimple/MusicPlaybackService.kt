package com.example.serveisimple

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MusicPlaybackService : Service() {

    companion object {
        const val MUSICA_RINGTONE = "com.example.serveisimple.RINGTONE"
        const val MUSICA_ALARM = "com.example.serveisimple.ALARM"
    }

    // declarem l'objecte MediaPlayer
    private lateinit var player: MediaPlayer

    // l'execució del servei començarà en cridar aquest mètode
    override fun onStartCommand(
        intent: Intent?, flags: Int, startId: Int
    ): Int {

        val uri = when (intent?.action) {
            MUSICA_RINGTONE -> Settings.System.DEFAULT_RINGTONE_URI
            MUSICA_ALARM ->  Settings.System.DEFAULT_ALARM_ALERT_URI
            else -> Settings.System.DEFAULT_RINGTONE_URI
        }

        // Creem un reproductor multimèdia que reproduirà el so de trucada per defecte
        player = MediaPlayer.create(
            this, uri
        )

        // Àudio en bucle
        player.isLooping = true

        // iniciem el procés
        player.start()

        // retorna l'estat del programa
        return START_STICKY
    }

    // L'execució del servei s'aturarà en cridar aquest mètode
    override fun onDestroy() {
        super.onDestroy()

        // aturem el procés
        player.stop()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}