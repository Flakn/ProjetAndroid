package com.example.projet_android.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZoneId
import java.util.Date

data class Game(val id: String, val title: String, val createdAt: Date) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getCreatedDateString(): String {
        return this.createdAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString()
    }
}